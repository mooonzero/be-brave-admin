package com.beBrave.admin.repository;

import com.beBrave.admin.entity.StockLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockLogRepository extends JpaRepository<StockLog, Long> {

    Long getDailySales(int dessertId, LocalDate date);
}
