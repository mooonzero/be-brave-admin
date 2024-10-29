package com.beBrave.admin.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
@Entity
@Getter
@Table(name = "DESSERT_CATEGORY")
public class DessertCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean deleted = false;

}
