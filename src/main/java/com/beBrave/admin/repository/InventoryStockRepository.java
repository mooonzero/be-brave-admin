package com.beBrave.admin.repository;

import com.beBrave.admin.entity.InventoryStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryStockRepository extends JpaRepository<InventoryStock,Integer> {

    Optional<InventoryStock> findByInventoryId(Integer id);
}
