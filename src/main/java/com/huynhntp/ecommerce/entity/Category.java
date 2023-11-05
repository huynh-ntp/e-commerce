package com.huynhntp.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category extends AuditInfo{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String code;
    @Column
    private String name;
    @Column
    private Boolean isActive = true;
    @Column
    private String parentId;
}
