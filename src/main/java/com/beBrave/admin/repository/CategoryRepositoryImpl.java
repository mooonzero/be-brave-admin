package com.beBrave.admin.repository;

import com.beBrave.admin.entity.QCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public abstract class CategoryRepositoryImpl implements CategoryRepository{


    private final JPAQueryFactory queryFactory;

    private final QCategory qCategory = QCategory.category;

    public String getCategoryNameById(int id){
        return queryFactory.select(qCategory.categoryName)
                .from(qCategory)
                .where(qCategory.id.eq(id))
                .fetchOne();
    }


}
