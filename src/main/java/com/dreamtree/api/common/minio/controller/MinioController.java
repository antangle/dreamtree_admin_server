package com.dreamtree.api.common.minio.controller;

import com.dreamtree.api.common.minio.service.MinioService;
import io.minio.GetObjectResponse;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("api/minio")
@RequiredArgsConstructor
public class MinioController {
    private final MinioService minioService;

    @PostMapping("/upload")
    public List<String> uploadFiles(
            @RequestPart("files") List<MultipartFile> files
    ) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        List<String> fileNames = new ArrayList<>();

        for (MultipartFile multipartFile : files) {
            String fileName = minioService.uploadFile(multipartFile);
            minioService.saveThumbnail(multipartFile, fileName);
            fileNames.add(fileName);
        }

        return fileNames;
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> getFile(@PathVariable String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        log.info(fileName);

        GetObjectResponse getObjectResponse = minioService.getObjectResponse(fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(getObjectResponse.headers().get("Content-Type")));

        byte[] fileByteArray = minioService.getByteArray(getObjectResponse);
        return new ResponseEntity<>(fileByteArray, headers, HttpStatus.OK);

    }
}