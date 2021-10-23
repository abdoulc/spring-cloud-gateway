package com.codewithabdel.inventoryservice.controller;

import com.codewithabdel.inventoryservice.entity.Inventory;
import com.codewithabdel.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/saveProductLine")
    public Inventory saveProductLine(@RequestBody Inventory inventory){
        return inventoryService.saveProductLine(inventory);
    }


}
