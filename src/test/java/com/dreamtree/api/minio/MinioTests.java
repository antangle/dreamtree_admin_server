package com.dreamtree.api.minio;

import com.dreamtree.api.common.minio.service.MinioService;
import com.dreamtree.api.domain.category.mapper.CategoryMapper;
import com.dreamtree.api.domain.program.dto.FileFormDTO;
import com.dreamtree.api.domain.program.dto.ProgramFormDTO;
import com.dreamtree.api.domain.program.dto.ProgramSearchDTO;
import com.dreamtree.api.domain.program.mapper.FileMapper;
import com.dreamtree.api.domain.program.mapper.ProgramMapper;
import io.minio.GetObjectResponse;
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
import java.util.ArrayList;
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
    public void getImages(){

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

        String bucketName = "bucket-file";
        String fileName = "2023-02-14T11:27:31.250638200dog.jpg";
        List<String> fileNames = new ArrayList<>();
        fileNames.add(fileName);

        minioService.deleteFile(fileNames);
    }


}
