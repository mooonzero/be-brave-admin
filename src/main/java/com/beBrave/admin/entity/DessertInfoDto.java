package com.beBrave.admin.entity;

import lombok.Data;

@Data
public class DessertInfoDto {
    private String categoryName;
    private String dessertName;
    private String memo;
    private int stock;
    private int sales;
    private int safetyStock;

    public DessertInfoDto(String categoryName, String dessertName, String memo, int stock, int sales, int safetyStock) {
        this.categoryName = categoryName;
        this.dessertName = dessertName;
        this.memo = memo;
        this.stock = stock;
        this.sales = sales;
        this.safetyStock = safetyStock;
    }

}
