package com.beBrave.admin.service;

import com.beBrave.admin.entity.InventoryStock;
import com.beBrave.admin.entity.StockLog;
import com.beBrave.admin.entity.StockType;
import com.beBrave.admin.repository.InventoryStockRepository;
import com.beBrave.admin.repository.StockLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StockFacadeService {

    @Autowired
    @Qualifier("stockLogRepository")
    StockLogRepository logRepository;

    @Autowired
    InventoryStockRepository stockRepository;


    public String updateStock(StockLog stockLog) {

        logRepository.save(stockLog);

        InventoryStock stock = stockRepository.findByInventoryId(stockLog.getInventoryId())
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        Long newStockQuantity;
        String returnMessage;

        if (stockLog.getStockType().equals(StockType.OUTBOUND)) {
            if (stock.getQuantity() < stockLog.getAmount()) {
                return "재고가 부족하여 출고 등록을 할 수 없습니다.";
            }
            newStockQuantity = stock.getQuantity() - stockLog.getAmount();
            returnMessage = "출고 등록 완료.";
        } else {
            newStockQuantity = stock.getQuantity() + stockLog.getAmount();
            returnMessage = "입고 등록 완료.";
        }

        stock.updateInventoryStock(newStockQuantity, stockLog.getLogDate());
        stockRepository.save(stock);

        return returnMessage;
    }
}
