package com.beBrave.admin.service;

import com.beBrave.admin.entity.StockLog;
import com.beBrave.admin.repository.StockLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockLogService {

    @Autowired
    private StockLogRepository repository;

    public void saveStockLog(StockLog stockLog){
        repository.save(stockLog);
    }
}
