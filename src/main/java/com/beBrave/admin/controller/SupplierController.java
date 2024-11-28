package com.beBrave.admin.controller;

import com.beBrave.admin.entity.Supplier;
import com.beBrave.admin.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @PostMapping(value = "/add")
    public String addSupplier(@RequestBody Supplier supplier) {
        return service.addSupplier(supplier);
    }
}
