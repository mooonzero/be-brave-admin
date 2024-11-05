package com.beBrave.admin.controller;

import com.beBrave.admin.entity.Dessert;
import com.beBrave.admin.entity.DessertInfoDto;
import com.beBrave.admin.service.DessertFacadeService;
import com.beBrave.admin.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/dessert")
public class DessertController {

    @Autowired
    private DessertService dessertService;

    @Autowired
    private DessertFacadeService dessertFacadeService;

    @PostMapping(value = "/add")
    public ResponseEntity<Dessert> addDesserts(@RequestBody Dessert dessert) {
        Dessert savedDessert = dessertService.addDessert(dessert);
        return ResponseEntity.ok(savedDessert);
    }

    @GetMapping(value = "/get")
    public Dessert getDessert(@RequestParam int dessertId) {
        return dessertService.getDessertById(dessertId);

    }

    @GetMapping(value = "/list")
    public Page<DessertInfoDto> getDessertInfoPage(@RequestParam LocalDate date,
                                                   @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return dessertFacadeService.getDessertInfoPage(date, pageable);
    }


}
