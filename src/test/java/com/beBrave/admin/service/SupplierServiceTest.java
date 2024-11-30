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
    private SupplierInfoDto infoDto;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        supplier = Supplier.builder().build();
        infoDto = SupplierInfoDto.builder()
                .supplierName("test")
                .type("type")
                .phone("1234")
                .url("www/")
                .build();

    }
    @Test
    void addSupplier() {

        //when
        when(repository.existsBySupplierName(infoDto.getSupplierName())).thenReturn(false);

        String result = service.addSupplier(infoDto);

        assertEquals("발주처 등록 성공",result);

        verify(repository,times(1)).save(any(Supplier.class));
    }

    @Test
    void addSupplierAlreadyExist(){

        when(repository.existsBySupplierName(infoDto.getSupplierName())).thenReturn(true);

        String result = service.addSupplier(infoDto);

        assertEquals("이미 등록된 발주처 입니다.",result);

        verify(repository,never()).save(any(Supplier.class));
    }

    @Test
    void getSupplier() {
        int supplierId = 1;
        Supplier supplierMock = Supplier.builder()
                .id(1)
                .supplierName("mock")
                .build();
        when(repository.getReferenceById(supplierId)).thenReturn(supplierMock);

        Supplier result = service.getSupplier(supplierId);

        assertEquals(result.getId(),supplierMock.getId());
        verify(repository,times(1)).getReferenceById(supplierId);

    }

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

        when(repository.findById(2)).thenReturn(Optional.empty());

        String result = service.updateSupplier(supplierInfo);

        assertEquals("등록되지 않은 발주처입니다.", result);

        verify(repository, times(1)).findById(2);
    }
}