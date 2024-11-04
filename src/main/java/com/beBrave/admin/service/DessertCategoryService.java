package com.beBrave.admin.service;

import com.beBrave.admin.repository.DessertCategoryRepository;
import com.beBrave.admin.entity.DessertCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DessertCategoryService {

    @Autowired
    @Qualifier("dessertCategoryRepository")
    private DessertCategoryRepository categoryRepository;

    public DessertCategory addDessertCategory(DessertCategory category) {
        return categoryRepository.save(category);
    }

    public String getCategoryName(int categoryId) {
        Optional<DessertCategory> dessertCategory = categoryRepository.findById(categoryId);
        return dessertCategory.get().getCategoryName();
    }

    public Map<Integer, String> getCategoryNameList(List<Integer> idList) {

        Map<Integer, String> categoryNameMap = new HashMap<>();
        for (int id : idList) {
            Optional<DessertCategory> category = categoryRepository.findById(id);
            categoryNameMap.put(id, category.get().getCategoryName());
        }
        return categoryNameMap;
    }

    public String updateDessertCategory(DessertCategory category) {
        return null;
    }

    public String deleteDessertCategory(int categoryId) {

        return "delete succeed";
    }
}
