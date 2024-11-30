package com.beBrave.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@Table(name = "SUPPLIER")
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private String supplierName;

    @Column(name = "type")
    private String type;

    @Column(name = "phone")
    private  String phone;

    @Column(name = "url")
    private String url;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "is_deleted")
    private Boolean deleted;

    public void updateSupplier(String name, String type, String phone, String url) {
        this.supplierName = name;
        this.type = type;
        this.phone = phone;
        this.url = url;
        this.updatedAt = LocalDate.now();
    }


}
