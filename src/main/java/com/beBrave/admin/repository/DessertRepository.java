package com.beBrave.admin.repository;

import com.beBrave.admin.entity.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DessertRepository extends JpaRepository<Dessert,Integer> {

    List<Dessert> findAllById(Integer id);

    Dessert findById(int id);
    Dessert findByDessertName(String dessertName);
}
