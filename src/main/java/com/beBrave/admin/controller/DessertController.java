package com.beBrave.admin.controller;

import com.beBrave.admin.entity.Dessert;
import com.beBrave.admin.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desserts")
public class DessertController {

    @Autowired
    private DessertService dessertService;

    @PostMapping(value = "/add")
    public ResponseEntity<Dessert> addDesserts(@RequestBody Dessert dessert) {
        Dessert savedDessert = dessertService.addDessert(dessert);
        return ResponseEntity.ok(savedDessert);
    }

    @GetMapping(value = "/get")
    public Dessert getDesserts(@RequestParam int dessertId) {
        return dessertService.getDessertById(dessertId);

    }


}
