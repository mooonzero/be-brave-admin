package com.beBrave.admin.service;

import com.beBrave.admin.entity.Category;
import com.beBrave.admin.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    @Qualifier("categoryRepository")
    private CategoryRepository repository;

    public String addCategory(String categoryName) {
        if (repository.existsByCategoryName(categoryName)) {
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
        return category.map(Category::getCategoryName).orElseGet(() -> {
                    log.error("등록되지 않은 카테고리 아이디 입니다. id : " + id);
                    return "Unknown category";
                }
        );
    }

    public Map<Integer, String> getCategoryNameMap(List<Integer> idList) {
        return idList.stream()
                .collect(Collectors.toMap(
                        id -> id,
                        id -> repository.findById(id).map(Category::getCategoryName)
                                .orElseGet(() -> {
                                            log.error("등록되지 않은 카테고리 아이디 입니다. id : " + id);
                                            return "Unknown category";
                                        }
                                )
                ));

    }

}
