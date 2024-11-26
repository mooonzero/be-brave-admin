package com.beBrave.admin.controller;

import com.beBrave.admin.entity.StockLog;
import com.beBrave.admin.service.StockFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockFacadeService stockFacadeService;

    @PostMapping(value = "/update")
    public String updateStock(@RequestBody StockLog stockLog){
        return stockFacadeService.updateStock(stockLog);
    }

}
