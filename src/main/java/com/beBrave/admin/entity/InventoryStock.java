package com.beBrave.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "INVEONTORY_STOCK")
public class InventoryStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "inventory_id", nullable = false)
    private int inventoryId;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @Column(name = "quantity", nullable = false)
    private Long quantity ;

    @Column(name = "note")
    private String note;

    public void updateInventoryStock(Long newQuantity, LocalDate updateTime){
        this.quantity = newQuantity;
        this.updatedAt = updateTime;
    }

    public InventoryStock(){
        this.quantity = 0L;
    }
}
