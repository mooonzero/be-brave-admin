package com.beBrave.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INVENTORY")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "inventory_name", nullable = false)
    private String inventoryName;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "location", nullable = false)
    private InventoryLocation inventoryLocation;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "memo")
    private String memo;

    @Column(name = "safety_stock", nullable = false)
    private int safetyStock = 10;

    @Column(name = "supplier_id", nullable = false)
    private int supplierId;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt = LocalDate.now();

    @Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean deleted = false;

}
