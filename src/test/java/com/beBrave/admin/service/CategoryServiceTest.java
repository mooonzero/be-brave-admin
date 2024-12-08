package com.beBrave.admin.service;

import com.beBrave.admin.entity.Category;
import com.beBrave.admin.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    CategoryRepository repository;

    @InjectMocks
    CategoryService service;

    private Category category;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        category = Category.builder().build();

    }

    @Test
    void addCategory() {
        String categoryName = "test";
        when(repository.existsByCategoryName(categoryName)).thenReturn(false);

        String result = service.addCategory(categoryName);

        assertEquals("카테고리 등록 성공", result);

        verify(repository, times(1)).save(any(Category.class));
    }

    @Test
    void addCategoryAlreadyExist() {
        String categoryName = "test";
        when(repository.existsByCategoryName(categoryName)).thenReturn(true);

        String result = service.addCategory(categoryName);

        assertEquals("이미 등록된 카테고리 이름 입니다.", result);

        verify(repository, never()).save(any(Category.class));
    }

    @Test
    void getCategoryName() {
        //given
        int categoryId = 1;
        Category testCategory = Category.builder()
                .id(1)
                .categoryName("category")
                .build();

        //when
        when(repository.findById(categoryId)).thenReturn(Optional.of(testCategory));
        String result = service.getCategoryName(categoryId);

        //then
        assertEquals("category", result);
        verify(repository, times(1)).findById(categoryId);
    }

    @Test
    void getCategoryNameNotFound() {
        // given
        int invalidId = 99;
        when(repository.findById(invalidId)).thenReturn(Optional.empty());

        // when
        String result = service.getCategoryName(invalidId);

        // then
        assertEquals("Unknown category", result);
        verify(repository, times(1)).findById(invalidId);

    }

    @Test
    void getCategoryNameMap() {
        //given
        List<Integer> idList = List.of(1, 2, 3);

        when(repository.findById(1)).thenReturn(Optional.of(Category.builder().id(1).categoryName("category1").build()));
        when(repository.findById(2)).thenReturn(Optional.of(Category.builder().id(2).categoryName("category2").build()));
        when(repository.findById(3)).thenReturn(Optional.of(Category.builder().id(3).categoryName("category3").build()));

        // when
        Map<Integer, String> result = service.getCategoryNameMap(idList);

        // then
        assertEquals("category1", result.get(1));
        assertEquals("category2", result.get(2));
        assertEquals("category3", result.get(3));

        for (int id : idList) {
            verify(repository, times(1)).findById(id);
        }
    }

    @Test
    void getCategoryNameMapWithUnknownId() {
        //given
        List<Integer> idList = List.of(1, 2, 3);

        when(repository.findById(1)).thenReturn(Optional.of(Category.builder().id(1).categoryName("category1").build()));
        when(repository.findById(2)).thenReturn(Optional.empty());
        when(repository.findById(3)).thenReturn(Optional.empty());

        //when
        Map<Integer, String> result = service.getCategoryNameMap(idList);

        // then
        assertEquals("category1", result.get(1));
        assertEquals("Unknown category", result.get(2));
        assertEquals("Unknown category", result.get(3));

        for (int id : idList) {
            verify(repository, times(1)).findById(id);
        }

    }
}