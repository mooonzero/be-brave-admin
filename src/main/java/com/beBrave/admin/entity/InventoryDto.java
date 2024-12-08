package com.beBrave.admin.entity;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
public class InventoryDto {

    private String inventoryName;
    private int categoryId;
    private String inventoryLocation;
    private BigDecimal price;
    private String memo;
    private int safetyStock;
    private int supplierId;
}
