package com.beBrave.admin.service;

import com.beBrave.admin.entity.Inventory;
import com.beBrave.admin.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public Inventory addInventory(Inventory inventory){
        return  repository.save(inventory);
    }

    public Inventory getInventoryById(int id){
        return  repository.findById(id);
    }

}

