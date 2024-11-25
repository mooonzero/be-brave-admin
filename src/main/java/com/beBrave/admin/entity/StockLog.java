package com.beBrave.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "STOCK_LOG")
public class StockLog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inventory_id",nullable = false)
    private int inventoryId;

    @Column(name = "user_id",nullable = false)
    private int userId;

    @Column(name = "log_type",nullable = false)
    private StockType stockType;

    @Column(name = "stock_amount")
    private Long amount = 0L;

    @Column(name = "log_date",nullable = false)
    private LocalDate logDate = LocalDate.now();

    @Column(name = "note")
    private String note;
}
