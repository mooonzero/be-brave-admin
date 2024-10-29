package com.beBrave.admin.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
@Entity
@Getter
@Table(name = "DESSERT_LOG")
public class DessertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "dessert_id", nullable = false)
    private int dessertId;

    @Column(name = "stock_type", nullable = false)
    private String stockType;

    @Column(name = "userId", nullable = false)
    private String userId;

}
