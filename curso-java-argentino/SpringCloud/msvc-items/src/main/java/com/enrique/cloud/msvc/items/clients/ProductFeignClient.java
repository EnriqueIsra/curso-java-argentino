package com.enrique.cloud.msvc.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.enrique.cloud.msvc.items.models.Product;

@FeignClient(url = "localhost:8001", name = "msvc-products")
public interface ProductFeignClient {

    @GetMapping
    List<Product> findAll();

    @GetMapping("/{id}")
    Product details(@PathVariable Long id);
}
