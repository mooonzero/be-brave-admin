package com.beBrave.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
@Entity
@Getter
@Table(name = "DESSERT_SALES")
public class DessertSales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "sold_at", nullable = false)
    private LocalDate soldAt;

    @Column(name = "dessert_id", nullable = false)
    private int dessertId;

    @Column(name = "quantity")
    private Long quantity = 0L;

    @Column(name = "note")
    private String note;

}
