package com.beBrave.admin.service;

import com.beBrave.admin.entity.Supplier;
import com.beBrave.admin.entity.SupplierInfoDto;
import com.beBrave.admin.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SupplierServiceTest {

    @Mock
    SupplierRepository repository;

    @InjectMocks
    SupplierService service;

    private Supplier supplier;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        supplier = new Supplier();
    }
    @Test
    void addSupplier() {

        when(repository.existsBySupplierName(supplier.getSupplierName())).thenReturn(false);

        String result = service.addSupplier(supplier);

        assertEquals("발주처 등록 성공",result);

        verify(repository,times(1)).save(supplier);
    }

    @Test
    void addSupplierAlreadyExist(){
        when(repository.existsBySupplierName(supplier.getSupplierName())).thenReturn(true);

        String result = service.addSupplier(supplier);

        assertEquals("이미 등록된 발주처 입니다.",result);

        verify(repository,never()).save(any(Supplier.class));
    }

//    @Test
//    void getSupplier() {
//
//
//    }

    @Test
    void updateSupplier() {
        SupplierInfoDto supplierInfo = SupplierInfoDto.builder()
                .supplierId(1)
                .supplierName("updatedSupplier")
                .type("type2")
                .phone("00")
                .url("www.supplier.com")
                .build();

        Supplier supplierMock = Mockito.mock(Supplier.class);
        when(repository.findById(1)).thenReturn(Optional.of(supplierMock));

        String result = service.updateSupplier(supplierInfo);

        assertEquals("발주처 업데이트 성공", result);

        verify(supplierMock).updateSupplier(anyString(), anyString(), anyString(), anyString());
    }
    @Test
    void updateSupplierWhenDoesntExist() {
        SupplierInfoDto supplierInfo = SupplierInfoDto.builder()
                .supplierId(2)
                .supplierName("updatedSupplier")
                .build();

        Supplier supplierMock = Mockito.mock(Supplier.class);
        when(repository.findById(2)).thenReturn(Optional.empty());

        String result = service.updateSupplier(supplierInfo);

        assertEquals("등록되지 않은 발주처입니다.", result);

        verify(repository, times(1)).findById(2);
    }
}