package com.beBrave.admin.repository;

import com.beBrave.admin.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    String getCategoryNameById(int id);
}
