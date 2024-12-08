package com.beBrave.admin.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CategoryDto {
    private String categoryName;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
