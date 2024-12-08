package com.beBrave.admin.service;

import com.beBrave.admin.entity.Inventory;
import com.beBrave.admin.entity.InventoryDto;
import com.beBrave.admin.entity.InventoryLocation;
import com.beBrave.admin.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@Slf4j
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public String addInventory(InventoryDto dto){
        InventoryLocation inventoryLocation = InventoryLocation.fromValue(dto.getInventoryLocation());

        if (repository.existsByInventoryName(dto.getInventoryName())){
            return "이미 존재하는 부자재 이름입니다";
        }
        Inventory inventory = Inventory.builder()
                .inventoryName(dto.getInventoryName())
                .categoryId(dto.getCategoryId())
                .inventoryLocation(inventoryLocation)
                .price(dto.getPrice())
                .memo(dto.getMemo())
                .safetyStock(dto.getSafetyStock())
                .supplierId(dto.getSupplierId())
                .createdAt(LocalDate.now())
                .build();
        repository.save(inventory);
        return "부자재 등록 성공";
    }

    public Inventory getInventoryById(int id) {
        return repository.findById(id);
    }

}

