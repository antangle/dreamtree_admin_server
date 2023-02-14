package com.dreamtree.api.common.minio.service;

import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.tasks.UnsupportedFormatException;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//이승윤 ver0.1
@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    @Value("${minio.bucket}")
    String bucketName;
    private final MinioClient minioClient;

    private String setUUID(String name) {
        return LocalDateTime.now() + name;
    }

    public List<Bucket> getBucketLists() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return minioClient.listBuckets();
    }

    public byte[] getByteArray(GetObjectResponse getObjectResponse) throws IOException {
        return IOUtils.toByteArray(getObjectResponse);
    }

    public GetObjectResponse getObjectResponse(String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        try {
            GetObjectResponse getObjectResponse = minioClient.getObject(GetObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .build()
            );

            return getObjectResponse;
        } catch (Exception e) {
            throw e;
        }
    }

    public String uploadFile(MultipartFile multipartFile, String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        try {
            log.info("File Uploaded...." + multipartFile.getName() + ", " + multipartFile.getContentType());

            fileName = setUUID(multipartFile.getOriginalFilename());
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .contentType(multipartFile.getContentType())
                    .object(fileName)
                    .stream(multipartFile.getInputStream(), multipartFile.getSize(), -1)
                    .build());

        } catch (Exception e) {
            throw e;
        }
//        return FileDTO.builder()
//                .title(request.getTitle())
//                .description(request.getDescription())
//                .size(request.getFile().getSize())
//                .url(getPreSignedUrl(request.getFile().getOriginalFilename()))
//                .filename(request.getFile().getOriginalFilename())
//                .build();
        return fileName;
    }

    public String uploadFile(MultipartFile multipartFile) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        try {
            log.info("File Uploaded...." + multipartFile.getName() + ", " + multipartFile.getContentType());

            String fileName = setUUID(multipartFile.getOriginalFilename());
            InputStream inputStream = multipartFile.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .contentType(multipartFile.getContentType())
                    .object(fileName)
                    .stream(inputStream, multipartFile.getSize(), -1)
                    .build());
            inputStream.close();
            return fileName;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void saveThumbnail(MultipartFile file, String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        try {
            InputStream thumbNailInputStream = getThumbNailInputStream(file);
            String thumbNailPrefix = "t_";

            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(thumbNailPrefix + fileName)
                    .contentType(file.getContentType())
                    .stream(thumbNailInputStream, thumbNailInputStream.available(), -1)
                    .build());
            thumbNailInputStream.close();
        } catch (Exception e) {
            throw e;
        }
    }

    private InputStream getThumbNailInputStream(MultipartFile file) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try{
            InputStream inputStream = file.getInputStream();
            Thumbnailator.createThumbnail(inputStream,bos,200,200);

            InputStream is = new ByteArrayInputStream(bos.toByteArray());
            inputStream.close();
            return is;
        } catch (Exception e){
            throw e;
        } finally {
            bos.close();
        }
    }

    @Override
    public void deleteFile(String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .build());

            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(bucketName)
                    .object("t_" + fileName)
                    .build());
        } catch (Exception e) {
            throw e;
        }

    }
    @Override
    public void deleteFile(List<String> filenames) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        try {
            List<DeleteObject> objects = new LinkedList<>();
            String thumbNailPrefix = "t_";

            for(String filename: filenames){
                objects.add(new DeleteObject(filename));
                objects.add(new DeleteObject(thumbNailPrefix + filename));
            }
            Iterable<Result<DeleteError>> results = minioClient.removeObjects(RemoveObjectsArgs.builder()
                    .bucket(bucketName)
                    .objects(objects)
                    .build());

            log.info("==========================================");
            for(Result<DeleteError> result : results){
                DeleteError error = result.get();
                log.info(error.objectName() + "\n" + error.message());
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
