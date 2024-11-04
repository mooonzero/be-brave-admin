package com.beBrave.admin.service;

import com.beBrave.admin.entity.Dessert;
import com.beBrave.admin.entity.DessertInfoDto;
import com.beBrave.admin.repository.DessertCategoryRepository;
import com.beBrave.admin.repository.DessertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DessertFacadeService {

    @Autowired
    private DessertRepository dessertRepository;

    @Qualifier("dessertCategoryRepository")
    @Autowired
    private DessertCategoryRepository categoryRepository;


    //list로 받아올 수 있게 수정
    public DessertInfoDto getDessertInfo(int dessertId){
        Dessert dessert = dessertRepository.findById(dessertId);
        String categoryName = categoryRepository.getCategoryNameById(dessert.getCategoryId());

        //재고, 판매량 가져오는  api 생성해야함 ;
        int stock = 1;
        int sales = 1;

        return new DessertInfoDto(categoryName,
                dessert.getDessertName(),
                dessert.getMemo(),
                stock,
                sales,
                dessert.getSafetyStock());

    }


}
