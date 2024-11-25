package com.beBrave.admin.service;

import com.beBrave.admin.entity.DessertSales;
import com.beBrave.admin.entity.StockLog;
import com.beBrave.admin.entity.StockType;
import com.beBrave.admin.repository.DessertSalesRepository;
import com.beBrave.admin.repository.StockLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DessertSalesFacadeService {

    @Autowired
    @Qualifier("stockLogRepository")
    StockLogRepository logRepository;

    @Autowired
    DessertSalesRepository salesRepository;

    @Transactional
    public String saveLogAndSales(StockLog stockLog) {

        logRepository.save(stockLog);

        DessertSales dessertSales = salesRepository.findByDessertId(stockLog.getInventoryId())
                .orElseThrow(() -> new RuntimeException("DessertSales not found"));

        Long newStock;
        String returnMessage;

        if (stockLog.getStockType().equals(StockType.OUTBOUND)) {
            if (dessertSales.getQuantity() < stockLog.getAmount()) {
                return "재고가 부족하여 출고 등록을 할 수 없습니다.";
            }
            newStock = dessertSales.getQuantity() - stockLog.getAmount();
            returnMessage = "출고 등록 완료.";

        } else {
            newStock = dessertSales.getQuantity() + stockLog.getAmount();
            returnMessage = "입고 등록 완료.";
        }

        dessertSales.updateDessertSales(newStock, stockLog.getLogDate());
        salesRepository.save(dessertSales);

        return returnMessage;
    }
}
