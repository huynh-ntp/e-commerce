package com.huynhntp.ecommerce.util;

import com.huynhntp.ecommerce.config.MinioConfig;
import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import lombok.SneakyThrows;
import org.hibernate.Remove;
import org.springframework.util.RouteMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MinioUtil {
    private static final String bucketName = "myBucket";

    @SneakyThrows
    public static String uploadFile(MultipartFile file, String prefixFileName) {
        MinioClient minioClient = MinioConfig.getClient();
        if (file != null && !file.isEmpty()) {
            StringBuilder fileName = new StringBuilder();
            String[] originFileName = StringUtils.cleanPath(file.getOriginalFilename()).split("\\.");
            String fileExtension = originFileName[originFileName.length - 1];
            fileName.append(prefixFileName)
                    .append(".")
                    .append(fileExtension);
            String contentType = file.getContentType();

            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!bucketExists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }

            InputStream inputStream = new ByteArrayInputStream(file.getBytes());
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName.toString())
                            .stream(inputStream, 1567, -1)
                            .contentType(contentType)
                            .build()
            );
            return fileName.toString();
        }
        return "";
    }

    @SneakyThrows
    public static String getFileUrl(String fileName) {
        String url = "";
        MinioClient minioClient = MinioConfig.getClient();
        try {
            url = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
        } catch (Exception exception) {
            System.out.println("Error occur when get presigned object in minio: " + exception.toString());
        }
        return url;
    }

    @SneakyThrows
    public InputStream getFile(String fileName) {
        try {
            MinioClient minioClient = MinioConfig.getClient();
            boolean bucketExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!bucketExist) {
                return minioClient.getObject(
                        GetObjectArgs.builder()
                                .bucket(bucketName)
                                .object(fileName)
                                .build()
                );
            }
        } catch (Exception exception) {
            System.out.println("Error occur when get file in minio: " + exception.toString());
        }
        return null;
    }

    @SneakyThrows
    public Boolean deleteFile(String fileName) {
        try {
            MinioClient minioClient = MinioConfig.getClient();
            boolean bucketExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!bucketExist) {
                minioClient.removeObject(
                        RemoveObjectArgs.builder()
                                .bucket(bucketName)
                                .object(fileName)
                                .build()
                );
                return true;
            }
        } catch (Exception exception) {
            System.out.println("Error occur when delete file in minio: " + exception.toString());
        }
        return false;
    }


}
