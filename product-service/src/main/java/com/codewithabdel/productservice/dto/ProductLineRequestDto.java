package com.codewithabdel.productservice.dto;

import com.codewithabdel.productservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductLineRequestDto {
    private Product product;
    private Inventory inventory;
}
