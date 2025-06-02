package com.example.order_service.FeignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service",url = "http://localhost:8081") // registered name in Eureka
public interface ProductClient {

    @GetMapping("/products/{id}")
    productServiceResponse getProductById(@PathVariable("id") Long id);
}
