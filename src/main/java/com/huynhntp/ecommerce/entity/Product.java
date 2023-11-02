package com.huynhntp.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "imgUrl")
    private String imgUrl;
    @Column(name = "description")
    private String description;
}
