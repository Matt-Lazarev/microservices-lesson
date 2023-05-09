package com.lazarev.productservice.service;

import com.lazarev.productservice.dto.ProductDto;
import com.lazarev.productservice.entity.Product;
import com.lazarev.productservice.mapper.ProductMapper;
import com.lazarev.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto getProductById(Integer id){
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.toProductDto(product);
    }

    public void saveProduct(ProductDto productDto){
        Product product = productMapper.toProduct(productDto);
        productRepository.save(product);
    }
}
