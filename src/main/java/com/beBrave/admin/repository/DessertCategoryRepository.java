package com.beBrave.admin.repository;

import com.beBrave.admin.entity.DessertCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DessertCategoryRepository extends JpaRepository<DessertCategory, Integer> {


    String getCategoryNameById(int id);
}
