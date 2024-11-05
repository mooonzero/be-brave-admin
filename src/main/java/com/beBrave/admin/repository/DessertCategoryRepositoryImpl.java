package com.beBrave.admin.repository;

import com.beBrave.admin.entity.QDessertCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public abstract class DessertCategoryRepositoryImpl implements DessertCategoryRepository {


    private final JPAQueryFactory queryFactory;


    private final QDessertCategory qDessertCategory = QDessertCategory.dessertCategory;

    @Override
    public String getCategoryNameById(int categoryId) {

        return queryFactory.select(qDessertCategory.categoryName)
                .from(qDessertCategory)
                .where(qDessertCategory.id.eq(categoryId))
                .fetchOne();

    }
}

