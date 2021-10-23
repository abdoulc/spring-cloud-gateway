package com.codewithabdel.inventoryservice.service;

import com.codewithabdel.inventoryservice.entity.Inventory;
import com.codewithabdel.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory saveProductLine(Inventory inventory){
        inventory.setStatusStock(process(inventory.getTotalQty()));
        return inventoryRepository.save(inventory);
    }

    private String process(int total){
        return total > 50?"suffisant":"rupture";
    }
}
