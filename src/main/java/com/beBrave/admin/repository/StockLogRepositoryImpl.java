package com.beBrave.admin.repository;

import com.beBrave.admin.entity.QStockLog;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public abstract class StockLogRepositoryImpl implements StockLogRepository {

    private final JPAQueryFactory queryFactory;
    private final QStockLog qStockLog = QStockLog.stockLog;


}

