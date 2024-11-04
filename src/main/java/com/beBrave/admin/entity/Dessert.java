package com.beBrave.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "DESSERTS")
public class Dessert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String dessertName;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "memo")
    private String memo;

    @Column(name = "safety_stock", nullable = false)
    private int safetyStock = 10;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt = LocalDate.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt = LocalDate.now();

    @Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean deleted = false;

    public Dessert() {

    }
}
