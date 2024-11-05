package com.beBrave.admin.controller;

import com.beBrave.admin.entity.DessertCategory;
import com.beBrave.admin.service.DessertCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dessert/category")
public class DessertCategoryController {

    @Autowired
    private DessertCategoryService categoryService;

    @PostMapping(value = "/add")
    public ResponseEntity<DessertCategory> addDessertCategory(@RequestBody DessertCategory category) {
        DessertCategory savedCategory = categoryService.addDessertCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping(value = "/name")
    public String getCategoryName(@RequestParam int categoryId) {
        return categoryService.getCategoryName(categoryId);
    }

    @GetMapping(value = "/names")
    public Map<Integer,String> getCategoryNames(@RequestParam List<Integer> ids){
        return  categoryService.getCategoryNameList(ids);
    }

}
