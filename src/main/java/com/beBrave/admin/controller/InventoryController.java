package com.beBrave.admin.controller;

import com.beBrave.admin.entity.Inventory;
import com.beBrave.admin.entity.InventoryInfoDto;
import com.beBrave.admin.service.InventoryFacadeService;
import com.beBrave.admin.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {


    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryFacadeService inventoryFacadeService;

    @PostMapping(value = "/add")
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        Inventory savedInventory = inventoryService.addInventory(inventory);
        return ResponseEntity.ok(savedInventory);
    }

    @GetMapping(value = "/get")
    public Inventory getDessert(@RequestParam int inventoryId) {
        return inventoryService.getInventoryById(inventoryId);

    }

    @GetMapping(value = "/list")
    public Page<InventoryInfoDto> getDessertInfoPage(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return inventoryFacadeService.getInventoryInfoPage(pageable);
    }


}
