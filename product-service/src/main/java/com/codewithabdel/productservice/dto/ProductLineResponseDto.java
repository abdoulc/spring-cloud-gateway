package com.codewithabdel.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductLineResponseDto {
    private int productId;
    private int totalQty;
    private String statutStock;
}
