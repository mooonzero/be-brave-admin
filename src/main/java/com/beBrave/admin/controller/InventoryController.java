package com.beBrave.admin.controller;

import com.beBrave.admin.entity.Inventory;
import com.beBrave.admin.entity.InventoryDto;
import com.beBrave.admin.entity.InventoryInfoDto;
import com.beBrave.admin.service.InventoryFacadeService;
import com.beBrave.admin.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/inventory")
public class InventoryController {


    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryFacadeService inventoryFacadeService;

    @PostMapping(value = "/add")
    public String addInventory(@RequestBody InventoryDto inventory) {
        return inventoryService.addInventory(inventory);
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
