package com.codewithabdel.productservice.service;

import com.codewithabdel.productservice.dto.Inventory;
import com.codewithabdel.productservice.dto.ProductLineRequestDto;
import com.codewithabdel.productservice.dto.ProductLineResponseDto;
import com.codewithabdel.productservice.entity.Product;
import com.codewithabdel.productservice.reposiroty.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate template;

    public ProductLineResponseDto saveProduct(ProductLineRequestDto productLineRequestDto){
        Product product = productLineRequestDto.getProduct();
        Product savedProd =    productRepository.save(product);
        Inventory inventory = productLineRequestDto.getInventory();
        inventory.setTotalQty(processStockLevel(product.getQty()));
        inventory.setProducId(savedProd.getId());

        Inventory inventoryServiceResponse = template
                .postForObject("http://INVENTORY-SERVICE/inventory/saveProductLine", inventory,Inventory.class);

         return new ProductLineResponseDto(savedProd.getId(),inventoryServiceResponse.getTotalQty(),inventoryServiceResponse.getStatusStock());
    }

    private int processStockLevel(int qty){
        Random r = new Random();
        //qty + random number between 1-10 (existing stock)
        return (r.nextInt((9) + 1) + 1) + qty;
    }
}
