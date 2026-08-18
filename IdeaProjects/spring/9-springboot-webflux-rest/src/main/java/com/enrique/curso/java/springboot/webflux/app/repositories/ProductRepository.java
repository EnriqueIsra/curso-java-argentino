package com.enrique.curso.java.springboot.webflux.app.repositories;

import com.enrique.curso.java.springboot.webflux.app.models.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String > {

}
