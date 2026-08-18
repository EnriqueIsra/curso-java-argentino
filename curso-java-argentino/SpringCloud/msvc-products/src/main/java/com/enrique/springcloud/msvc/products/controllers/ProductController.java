package com.enrique.springcloud.msvc.products.controllers;

import com.enrique.springcloud.msvc.products.entities.Product;
import com.enrique.springcloud.msvc.products.services.ProductService;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        Optional<Product> producOptional = service.findById(id);
        if (producOptional.isPresent()) {
            return ResponseEntity.ok(producOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    
    
}
