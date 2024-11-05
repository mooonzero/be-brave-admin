package com.beBrave.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
@Entity
@Getter
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false, length = 10)
    private String userName;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @Column(name = "isDeleted", nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean deleted = false;

}
