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

    public String addCategory(String categoryName){
        if (repository.existsByCategoryName(categoryName)){
            return "이미 등록된 카테고리 이름 입니다.";
        }
        Category category = Category.builder()
                .categoryName(categoryName)
                .build();
        repository.save(category);
        return "카테고리 등록 성공";
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
