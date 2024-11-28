package com.beBrave.admin.controller;

import com.beBrave.admin.entity.Supplier;
import com.beBrave.admin.entity.SupplierInfoDto;
import com.beBrave.admin.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @PostMapping(value = "/add")
    public String addSupplier(@RequestBody Supplier supplier) {
        return service.addSupplier(supplier);
    }

    @GetMapping(value = "/get")
    public Supplier getSupplier(@RequestParam int supplierId) {
        return service.getSupplier(supplierId);
    }

    @GetMapping(value = "/update")
    public String updateSupplier(@RequestBody SupplierInfoDto infoDto) {
        return service.updateSupplier(infoDto);
    }
}
