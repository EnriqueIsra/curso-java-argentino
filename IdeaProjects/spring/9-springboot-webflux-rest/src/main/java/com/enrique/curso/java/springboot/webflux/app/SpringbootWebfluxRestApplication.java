package com.enrique.curso.java.springboot.webflux.app;

import com.enrique.curso.java.springboot.webflux.app.models.Category;
import com.enrique.curso.java.springboot.webflux.app.models.Product;
import com.enrique.curso.java.springboot.webflux.app.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringbootWebfluxRestApplication implements CommandLineRunner {

	private final ProductService service;
	private final ReactiveMongoTemplate mongoTemplate;

	public SpringbootWebfluxRestApplication(ProductService service, ReactiveMongoTemplate mongoTemplate) {
		this.service = service;
		this.mongoTemplate = mongoTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.mongoTemplate.dropCollection("products");
		this.mongoTemplate.dropCollection("categories");

		Category electronics = new Category("Electronica");
		Category sport = new Category("Deporte");
		Category computing = new Category("Computacion");
		Category furniture = new Category("Muebles");

		Flux.just(electronics, sport, computing, furniture)
				.flatMap(service::saveCategory)
				.doOnNext(category -> System.out.println("Categoria creada: ".concat(category.getName()).concat(" ").concat(category.getId())))
				.thenMany(
						Flux.just(
								new Product("TV Panasonic", 342.67, electronics),
								new Product("Sony Camara", 500.99, electronics),
								new Product("Apple iPod", 245.89, electronics),
								new Product("Notebook Sony", 2000.67, computing),
								new Product("Hewlett Packard Multifuncional Impresora", 600.55, computing),
								new Product("Bianchi Bicicleta", 3500.89, sport),
								new Product("Mueble mica 5 cajones", 250.78, furniture)
						).flatMap(product -> {
							product.setCreateAt(LocalDateTime.now());
							return service.save(product);
						})
				).subscribe(product -> System.out.println("Insert: ".concat(product.getId()).concat(" ").concat(product.getName())));
	}
}
