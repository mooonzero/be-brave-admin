package com.beBrave.admin.controller;

import com.beBrave.admin.entity.StockLog;
import com.beBrave.admin.service.StockLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/log")
public class StockLogController {

    @Autowired
    private StockLogService stockLogService;

    @PostMapping(value = "/save")
    public void saveStockLog(@RequestBody StockLog stockLog){
        stockLogService.saveStockLog(stockLog);
    }

}
