package com.lazarev.orderservice.client;

import com.lazarev.orderservice.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductClient {
    private static final String PRODUCT_SERVICE_URL = "http://product-service:8081";
    private static final String GET_PRODUCT_URL = "/api/products/{id}";

    private final RestTemplate restTemplate;

    public ProductDto getProductById(Integer productId){
        String url = PRODUCT_SERVICE_URL + GET_PRODUCT_URL;
        return restTemplate.getForObject(url, ProductDto.class, productId);
    }
}
