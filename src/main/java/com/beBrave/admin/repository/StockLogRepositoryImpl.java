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

    @Override
    public Long getDailySales(int dessertId, LocalDate date) {

        return Optional.ofNullable(queryFactory.select(qStockLog.amount.sum())
                        .where(qStockLog.dessertId.eq(dessertId)
                                .and(qStockLog.stockType.eq(StockType.OUTBOUND))
                                .and(qStockLog.logDate.eq(date)))
                        .fetchOne())
                .orElse(0L);

    }
}

