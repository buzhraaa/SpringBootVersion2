package com.example.amazonmarketplace.services;

import com.example.amazonmarketplace.dto.ProductDto;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);

    ProductDto getProductById(Long id);

}