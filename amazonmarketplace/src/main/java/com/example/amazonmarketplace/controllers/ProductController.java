package com.example.amazonmarketplace.controllers;

import com.example.amazonmarketplace.dto.ProductDto;
import com.example.amazonmarketplace.services.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProductDto = productService.saveProduct(productDto);
        return ResponseEntity.ok(savedProductDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        ProductDto productDto = productService.getProductById(id);
        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        } else {
            String response = "Product with id " + id + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}