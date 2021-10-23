package com.codewithabdel.productservice.controller;

import com.codewithabdel.productservice.dto.ProductLineRequestDto;
import com.codewithabdel.productservice.dto.ProductLineResponseDto;
import com.codewithabdel.productservice.entity.Product;
import com.codewithabdel.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public ProductLineResponseDto saveProduct(@RequestBody ProductLineRequestDto productLineRequestDto){
        return productService.saveProduct(productLineRequestDto);
    }
}
