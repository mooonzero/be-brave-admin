package com.beBrave.admin.service;

import com.beBrave.admin.entity.Supplier;
import com.beBrave.admin.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository repository;

    public String addSupplier(Supplier supplier) {
        String supplierName = supplier.getSupplierName();
        if (repository.existsBySupplierName(supplierName)) {
            return "이미 등록된 발주처 입니다.";
        }
        repository.save(supplier);
        return "발주처 등록 성공";
    }

}
