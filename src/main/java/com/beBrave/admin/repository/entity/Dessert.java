package com.beBrave.admin.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "DESSERT")
public class Dessert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "dessert_name", nullable = false)
    private String dessertName;

    @Column(name = "stock", nullable = false)
    private Long stock = 0L;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean deleted = false;

    public Dessert() {

    }
}
