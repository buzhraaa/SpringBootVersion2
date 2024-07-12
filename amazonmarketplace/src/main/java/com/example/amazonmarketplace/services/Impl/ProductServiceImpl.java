package com.example.amazonmarketplace.services.Impl;

import com.example.amazonmarketplace.dto.ProductDto;
import com.example.amazonmarketplace.mapper.ProductMapper;
import com.example.amazonmarketplace.models.Product;
import com.example.amazonmarketplace.repositories.ProductRepository;
import com.example.amazonmarketplace.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(productMapper::toDTO).orElse(null);
    }

}