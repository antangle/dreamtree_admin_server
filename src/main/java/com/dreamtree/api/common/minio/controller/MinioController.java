package com.dreamtree.api.common.minio.controller;

import com.dreamtree.api.domain.program.dto.FileTypeDTO;
import com.dreamtree.api.common.minio.service.MinioService;
import io.minio.GetObjectResponse;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;



//이승윤 ver0.2
@RestController
@Log4j2
@RequestMapping("api/minio")
@RequiredArgsConstructor
public class MinioController {
    private final MinioService minioService;

    @PostMapping("/upload")
    public List<FileTypeDTO> uploadFiles(
            @RequestPart("files") List<MultipartFile> files
    ) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        List<FileTypeDTO> fileNames = new ArrayList<>();

        for (MultipartFile multipartFile : files) {
            String fileName = minioService.uploadFile(multipartFile);
            if(!multipartFile.getContentType().equals("video/mp4")){
                log.info("mp4파일이아니닭");
                minioService.saveThumbnail(multipartFile, fileName);
            } else{
                log.info("mp4파일이닭");
            }
            fileNames.add(
                    FileTypeDTO.builder()
                        .filename(fileName)
                        .contentType(multipartFile.getContentType())
                    .build());
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

    @GetMapping(value = "/video/{fileName}", produces = "video/mp4")
    public Resource getVideoFile(@PathVariable String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        log.info("===================video===================");

        GetObjectResponse getObjectResponse = minioService.getObjectResponse(fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(getObjectResponse.headers().get("Content-Type")));

        log.info(headers);

        InputStreamResource inputStreamResource = new InputStreamResource(getObjectResponse);

        return inputStreamResource;
    }

    @GetMapping(path = "/test", produces = "video/mp4")
    public Resource video() throws FileNotFoundException {
        return new InputStreamResource(new FileInputStream("D:\\sample\\file_example_MP4_480_1_5MG.mp4"));
    }

    @DeleteMapping("")
    public void deleteMinioImage(@RequestBody List<String> fileNameList) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioService.deleteFile(fileNameList);
    }
}