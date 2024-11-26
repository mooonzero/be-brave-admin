package com.beBrave.admin.controller;

import com.beBrave.admin.entity.Category;
import com.beBrave.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/add")
    public void addCategory(@RequestBody Category category){
        Category savedCategory = categoryService.addCategory(category);
    }


    @GetMapping(value = "/name")
    public String getCategoryName(@RequestParam int categoryId) {
        return categoryService.getCategoryName(categoryId);
    }

    @GetMapping(value = "/names")
    public Map<Integer,String> getCategoryNames(@RequestParam List<Integer> ids){
        return categoryService.getCategoryNameMap(ids);
    }

}
