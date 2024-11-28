package com.beBrave.admin.repository;

import com.beBrave.admin.entity.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {


    Inventory findById(int id);

    Boolean existsByInventoryName(String inventoryName);

    Inventory findByInventoryName(String inventoryName);

    Page<Inventory> findAll(Pageable pageable);
}
