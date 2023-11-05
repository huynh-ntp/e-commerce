package com.huynhntp.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;


@Entity
@Table(name = "product")
@Data
@Audited
public class Product extends AuditInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column()
    private String code;
    @Column()
    private String name;
    @Column()
    private String description;
    @Column()
    private Boolean isActive;
    @Column
    private String categoryId;
}
