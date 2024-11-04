package com.beBrave.admin.service;

import com.beBrave.admin.entity.Dessert;
import com.beBrave.admin.repository.DessertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DessertService {

    @Autowired
    private DessertRepository repository;

    public Dessert addDessert(Dessert dessert) {
        return repository.save(dessert);
    }

    public Dessert getDessertById(int id) {
        return repository.findById(id);
    }

    public Dessert getDessertByDessertName(String dessertName) {
        return repository.findByDessertName(dessertName);
    }


}
