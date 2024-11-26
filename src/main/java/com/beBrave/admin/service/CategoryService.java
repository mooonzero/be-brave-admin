package com.beBrave.admin.service;

import com.beBrave.admin.entity.Category;
import com.beBrave.admin.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    @Qualifier("categoryRepository")
    private CategoryRepository repository;

    public Category addCategory(Category category) {
        return repository.save(category);
    }

    public String getCategoryName(int id) {
        Optional<Category> category = repository.findById(id);
        return category.get().getCategoryName();
    }

    public Map<Integer, String> getCategoryNameMap(List<Integer> idList) {
        Map<Integer, String> categoryNameMap = new HashMap<>();
        for (int id : idList) {
            Optional<Category> category = repository.findById(id);
            categoryNameMap.put(id, category.get().getCategoryName());
        }
        return categoryNameMap;
    }

}
