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

    @Column(name = "dessert_id", nullable = false)
    private int dessertId;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @Column(name = "quantity", nullable = false)
    private Long quantity ;

    @Column(name = "note")
    private String note;

    public void updateDessertSales(Long newQuantity, LocalDate updateTime){
        this.quantity = newQuantity;
        this.updatedAt = updateTime;
    }

    public DessertSales(){
        this.quantity = 0L;
    }
}
