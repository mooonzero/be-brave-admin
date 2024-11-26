package com.beBrave.admin.entity;

import lombok.Data;

@Data
public class InventoryInfoDto {

    private String categoryName;
    private String inventoryName;
    private InventoryLocation location;
    private Long stock;
    private int safetyStock;
    private String supplierName;
    private String supplierUrl;

    public InventoryInfoDto(String categoryName, String inventoryName, InventoryLocation location,
                            Long stock, int safetyStock, String supplierName, String supplierUrl) {
        this.categoryName = categoryName;
        this.inventoryName = inventoryName;
        this.location = location;
        this.stock = stock;
        this.safetyStock = safetyStock;
        this.supplierName = supplierName;
        this.supplierUrl = supplierUrl;
    }
}
