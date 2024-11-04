package com.beBrave.admin.entity;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "DESSERT_CATEGORY")
public class DessertCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String categoryName;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt = LocalDate.now();

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean isDeleted = false;

    @Builder
    public DessertCategory(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

}
