package com.huynhntp.ecommerce.config;

import io.minio.MinioClient;

public class MinioConfig {
    public static MinioClient getClient(){
        MinioClient minioClient = MinioClient.builder().endpoint("https://localhost:9001")
                .credentials("htyelsvYLHoAUBTN03pB","plFAmwNU3pudyW8eA0dsjc2ljOt9jOKrovziSCUk")
                .build();
        return minioClient;
    }
}
