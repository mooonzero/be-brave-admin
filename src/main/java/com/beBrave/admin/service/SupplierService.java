package com.beBrave.admin.service;

import com.beBrave.admin.entity.Supplier;
import com.beBrave.admin.entity.SupplierInfoDto;
import com.beBrave.admin.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository repository;

    public String addSupplier(SupplierInfoDto infoDto) {
        String supplierName = infoDto.getSupplierName();
        if (repository.existsBySupplierName(supplierName)) {
            return "이미 등록된 발주처 입니다.";
        }
        Supplier supplier = Supplier.builder()
                .supplierName(infoDto.getSupplierName())
                .type(infoDto.getType())
                .phone(infoDto.getPhone())
                .url(infoDto.getUrl())
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .deleted(false)
                .build();

        repository.save(supplier);
        return "발주처 등록 성공";
    }


    public Supplier getSupplier(int supplierId) {
        return repository.getReferenceById(supplierId);
    }

    public String updateSupplier(SupplierInfoDto supplierInfo) {
        int supplierId = supplierInfo.getSupplierId();

        Optional<Supplier> supplier = repository.findById(supplierId);
        String returnMessage = supplier.map(
                s -> {s.updateSupplier(
                        supplierInfo.getSupplierName(),
                        supplierInfo.getType(),
                        supplierInfo.getPhone(),
                        supplierInfo.getUrl());
                   return "발주처 업데이트 성공";
                }
        ).orElse("등록되지 않은 발주처입니다.");

        return returnMessage;
    }

}
