package com.huynhntp.ecommerce.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditInfo {

    @CreatedBy
    protected String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected LocalDateTime createDate;

    @LastModifiedBy
    protected String updateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected LocalDateTime updateDate;
}
