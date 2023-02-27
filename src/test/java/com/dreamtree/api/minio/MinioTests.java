package com.dreamtree.api.minio;

import com.dreamtree.api.common.minio.service.MinioService;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SpringBootTest
@Log4j2
public class MinioTests {

    @Autowired(required = false)
    MinioService minioService;

    @Autowired(required = false)
    MinioClient minioClient;

    @Test
    public void getBucketListsTests() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        log.info(minioService.getBucketLists());
    }


    @Test
    public void temp() throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "2023-02-22T11:02:25.845215900dog.jpg",
                "2023-02-22T11:02:25.845215900dog.jpg",
                "image/jpg",
                new FileInputStream("/D:/dog.jpg")
        );
        minioClient.putObject(PutObjectArgs.builder()
                .bucket("bucket-file")
                .contentType(mockMultipartFile.getContentType())
                .object("2023-02-22T11:02:25.845215900dog.jpg")
                .stream(mockMultipartFile.getInputStream(), mockMultipartFile.getSize(), -1)
                .build());

    }

    @Test
    public void updateImageTest() throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "2023-02-22T11:02:25.845215900dog.jpg",
                "2023-02-22T11:02:25.845215900dog.jpg",
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
    public void uploadVideoTest() throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "sampleVid.mp4",
                "sampleVid.mp4",
                "video/mp4",
                new FileInputStream("/D:/sample/file_example_MP4_480_1_5MG.mp4")
        );


        String fileName = "file_example_MP4_480_1_5MG";
        log.info(minioService.uploadFile(mockMultipartFile, fileName));
    }

    @Test
    public void getVideoTest() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        GetObjectResponse getObjectResponse = minioService.getObjectResponse("2023-02-27T14:11:54.139306600sampleVid.mp4");
        log.info(getObjectResponse);
    }
    @Test
    public void deleteImages() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        minioService.deleteFile(List.of("2023-02-17T13:13:06.215023900dog.jpg"));
    }


}
