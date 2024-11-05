package com.beBrave.admin.service;

import com.beBrave.admin.entity.Dessert;
import com.beBrave.admin.entity.DessertInfoDto;
import com.beBrave.admin.entity.DessertSales;
import com.beBrave.admin.repository.DessertCategoryRepository;
import com.beBrave.admin.repository.DessertRepository;
import com.beBrave.admin.repository.DessertSalesRepository;
import com.beBrave.admin.repository.StockLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DessertFacadeService {

    @Autowired
    private DessertRepository dessertRepository;

    @Qualifier("dessertCategoryRepository")
    @Autowired
    private DessertCategoryRepository categoryRepository;

    @Autowired
    private DessertSalesRepository salesRepository;

    @Autowired
    @Qualifier("stockLogRepository")
    StockLogRepository logRepository;

    public DessertInfoDto getDessertInfo(int dessertId, LocalDate date) {
        Dessert dessert = dessertRepository.findById(dessertId);
        String categoryName = categoryRepository.getCategoryNameById(dessert.getCategoryId());
        DessertSales dessertSales = salesRepository.findByDessertId(dessertId)
                .orElseThrow(() -> new RuntimeException("DessertSales not found"));

        Long stock = dessertSales.getQuantity();
        Long sales = logRepository.getDailySales(dessertId, date);

        return new DessertInfoDto(categoryName,
                dessert.getDessertName(),
                dessert.getMemo(),
                stock,
                sales,
                dessert.getSafetyStock());

    }

    public Page<DessertInfoDto> getDessertInfoPage(LocalDate date, Pageable pageable) {

        Page<Dessert> desserts = dessertRepository.findAll(pageable);
        return desserts.map(
                dessert -> {
                    String categoryName = categoryRepository.getCategoryNameById(dessert.getCategoryId());
                    DessertSales dessertSales = salesRepository.findByDessertId(dessert.getId())
                            .orElse(new DessertSales());

                    Long stock = dessertSales.getQuantity();
                    Long sales = logRepository.getDailySales(dessert.getId(), date);

                    return new DessertInfoDto(categoryName,
                            dessert.getDessertName(),
                            dessert.getMemo(),
                            stock,
                            sales,
                            dessert.getSafetyStock());

                }
        );

    }


}
