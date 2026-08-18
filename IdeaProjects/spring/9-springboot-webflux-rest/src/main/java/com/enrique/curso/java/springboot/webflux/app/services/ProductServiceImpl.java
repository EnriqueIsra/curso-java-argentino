package com.enrique.curso.java.springboot.webflux.app.services;

import com.enrique.curso.java.springboot.webflux.app.models.Category;
import com.enrique.curso.java.springboot.webflux.app.models.Product;
import com.enrique.curso.java.springboot.webflux.app.repositories.CategoryRepository;
import com.enrique.curso.java.springboot.webflux.app.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Flux<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Product> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        return repository.save(product);
    }

    @Override
    public Mono<Void> delete(Product product) {
        return repository.delete(product);
    }

    @Override
    public Mono<Category> saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
