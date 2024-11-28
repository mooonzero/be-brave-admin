package com.beBrave.admin.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryInfoDto {

    private String categoryName;
    private String inventoryName;
    private InventoryLocation location;
    private Long stock;
    private int safetyStock;
    private String supplierName;
    private String supplierUrl;

}
