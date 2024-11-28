package com.beBrave.admin.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class SupplierInfoDto {
    private int supplierId;
    private String supplierName;
    private String type;
    private String phone;
    private String url;
}
