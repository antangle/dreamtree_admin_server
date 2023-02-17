package com.dreamtree.api.minio;

import com.dreamtree.api.common.minio.service.MinioService;
import io.minio.errors.*;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SpringBootTest
@Log4j2
public class MinioTests {

    @Autowired(required = false)
    MinioService minioService;

    @Test
    public void getBucketListsTests() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        log.info(minioService.getBucketLists());
    }


    @Test
    public void updateImageTest() throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "test",
                "dog.jpg",
                "image/jpg",
                new FileInputStream("/D:/dog.jpg")
        );

//        FileDTO fileDTO = FileDTO.builder()
//                .title("testFile")
//                .description("test file")
//                .file(mockMultipartFile)
//                .build();

        String bucketName = "bucket-file";
        String fileName = "fileName";
        log.info(minioService.uploadFile(mockMultipartFile, fileName));

        minioService.saveThumbnail(mockMultipartFile, "t_" + mockMultipartFile.getOriginalFilename());
    }
    @Test
    public void deleteImages() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        minioService.deleteFile(List.of("2023-02-17T13:13:06.215023900dog.jpg"));
    }


}
