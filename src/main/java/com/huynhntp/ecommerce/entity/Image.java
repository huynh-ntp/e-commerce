package com.huynhntp.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Image extends AuditInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String url;
    @Column
    private Boolean isMain;
    @Column
    private Boolean isActive;
    @Column
    private String productId;

}
