package com.enrique.curso.java.springboot.reactor.app;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringbootReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringbootReactorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mapAndFilter();
	}
	private void mapAndFilter() {
		Flux<String> names = Flux.just("Andres", "Diego", "María", "Pedro", "Juan", "Bruce")
				.map(String::toUpperCase)
				.doOnNext(name -> {
					if(name.isBlank()) {
						throw new RuntimeException("Nombres no pueden ser vacíos");
					}
					System.out.println(name.toLowerCase());
				})
				;

		names.subscribe(
				log::info,
				error -> log.error(error.getMessage()),
				() -> log.info("El flujo finalizó correctamente del Observable")
		);
	}
	private void subscribeAndOnNext() {
		Flux<String> names = Flux.just("Andres", "Diego", "María", "Pedro", "Juan", "Bruce")
				.doOnNext(System.out::println)
				.doOnNext(name -> System.out.println(name.toUpperCase()))
				.doOnNext(name -> {
					if(name.isBlank()) {
						throw new RuntimeException("Nombres no pueden ser vacíos");
					}
					System.out.println(name.toLowerCase());
				});
		names.subscribe(
				log::info,
				error -> log.error(error.getMessage()),
				() -> log.info("El flujo finalizó correctamente del Observable")
		);
//		names.subscribe(new Subscriber<String>() {
//			@Override
//			public void onSubscribe(Subscription subscription) {
//				subscription.request(2);
//			}
//
//			@Override
//			public void onNext(String string) {
//				log.info(string);
//			}
//
//			@Override
//			public void onError(Throwable throwable) {
//				log.error(throwable.getMessage());
//			}
//
//			@Override
//			public void onComplete() {
//				log.info("El flujo finalizó correctamente del Observable");
//			}
//		});
	}
}
