package com.beBrave.admin.service;

import com.beBrave.admin.entity.Inventory;
import com.beBrave.admin.entity.InventoryInfoDto;
import com.beBrave.admin.entity.InventoryStock;
import com.beBrave.admin.entity.Supplier;
import com.beBrave.admin.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InventoryFacadeService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    @Qualifier("categoryRepository")
    private CategoryRepository categoryRepository;

    @Autowired
    private InventoryStockRepository inventoryStockRepository;

    @Autowired
    private SupplierRepository supplierRepository;


    public Page<InventoryInfoDto> getInventoryInfoPage(Pageable pageable) {

        Page<Inventory> inventories = inventoryRepository.findAll(pageable);

        return inventories.map(
                inventory -> {
                    String categoryName = categoryRepository.getCategoryNameById(inventory.getCategoryId());
                    InventoryStock stock = inventoryStockRepository.findByInventoryId(inventory.getId())
                            .orElse(new InventoryStock());
                    Supplier supplier = supplierRepository.getReferenceById(inventory.getSupplierId());

                    return new InventoryInfoDto(
                            categoryName,
                            inventory.getInventoryName(),
                            inventory.getInventoryLocation(),
                            stock.getQuantity(),
                            inventory.getSafetyStock(),
                            supplier.getName(),
                            supplier.getUrl()
                    );
                }
        );
    }

}
