package com.beBrave.admin.repository;

import com.beBrave.admin.entity.QStockLog;
import com.beBrave.admin.entity.StockType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public abstract class StockLogRepositoryImpl implements StockLogRepository {

    private final JPAQueryFactory queryFactory;
    private final QStockLog qStockLog = QStockLog.stockLog;


}

