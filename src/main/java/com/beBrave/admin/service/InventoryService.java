package com.beBrave.admin.service;

import com.beBrave.admin.entity.Inventory;
import com.beBrave.admin.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public String addInventory(Inventory inventory) {
        String inventoryName = inventory.getInventoryName();

        if (repository.existsByInventoryName(inventoryName)) {
            return "이미 존재하는 부자재 이름입니다";
        }
        repository.save(inventory);
        return "부자재 등록 성공";
    }

    public Inventory getInventoryById(int id) {
        return repository.findById(id);
    }

}

