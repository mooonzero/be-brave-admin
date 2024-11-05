package com.beBrave.admin.repository;

import com.beBrave.admin.entity.DessertSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DessertSalesRepository extends JpaRepository<DessertSales, Integer> {

    Optional<DessertSales> findByDessertId(int dessertId);

}
