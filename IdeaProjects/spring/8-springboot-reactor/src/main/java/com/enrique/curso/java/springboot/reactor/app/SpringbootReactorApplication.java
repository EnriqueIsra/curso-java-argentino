package com.enrique.curso.java.springboot.reactor.app;

import com.enrique.curso.java.springboot.reactor.app.models.User;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringbootReactorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringbootReactorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mapAndFilter4User();
    }

    private void mapAndFilter4User() {
        Flux<String> names = Flux.just(
                "Alejandra Sánchez",
                "Enrique Mendoza",
                "Santiago Torres",
                "Sebastian Torres",
                "Samuel Mendoza");

        Flux<User> users = names.map(String::trim)
                .doOnNext(name -> {
                    String[] parts = name.split("\\s+");

                    if (name.isBlank() || parts.length < 2) {
                        throw new RuntimeException("Nombres ni Apellidos no pueden ser vacíos");
                    }
                })
                .map(name -> {
                    String[] parts = name.split("\\s+");
                    return new User(parts[0], parts[1]);
                })
                .filter(user -> user.getLastname().length() == 7)
                .doOnNext(System.out::println)
                .filter(user -> user.getLastname().equalsIgnoreCase("mendoza"))
                .doOnNext(user -> {
                    if (user.getLastname().isEmpty() || user.getName().isEmpty()) {
                        throw new RuntimeException("Nombres ni Apellidos no pueden ser vacíos");
                    }
                    System.out.println(user.getLastname().length());
                })
                .map(user -> {
                    String lastnameUpperCase = user.getLastname().toUpperCase();
                    user.setLastname(lastnameUpperCase);
                    user.setCreatedAt(LocalDateTime.now());
                    return user;
                });

        names.subscribe(System.out::println);
        users.subscribe(
                (user) -> log.info(user.toString()),
                error -> log.error(error.getMessage()),
                () -> log.info("El flujo finalizó correctamente del Observable")
        );
    }

    private void mapAndFilter3User() {
        Flux<User> names = Flux.just("Alejandra", "Enrique Mendoza", "Santiago Torres", "Sebastian Torres", "Samuel Mendoza")
                .map(name -> new User(name.split(" ")[0], name.split(" ")[1]))
                .filter(user -> user.getLastname().length() == 7)
                .doOnNext(System.out::println)
                .filter(user -> user.getLastname().equalsIgnoreCase("mendoza"))
                .doOnNext(user -> {
                    if (user.getLastname().isEmpty() || user.getName().isEmpty()) {
                        throw new RuntimeException("Nombres ni Apellidos no pueden ser vacíos");
                    }
                    System.out.println(user.getLastname().length());
                })
                .map(user -> {
                    String lastnameUpperCase = user.getLastname().toUpperCase();
                    user.setLastname(lastnameUpperCase);
                    user.setCreatedAt(LocalDateTime.now());
                    return user;
                });

        names.subscribe(
                (user) -> log.info(user.toString()),
                error -> log.error(error.getMessage()),
                () -> log.info("El flujo finalizó correctamente del Observable")
        );
    }

    private void mapAndFilter2Integer() {
        Flux<Integer> names = Flux.just("Andres", "Diego", "María", "Pedro", "Juan", "Bruce")
                .map(String::length)
                .doOnNext(length -> {
                    if (length == 0) {
                        throw new RuntimeException("Nombres no pueden ser vacíos");
                    }
                    System.out.println(length);
                });

        names.subscribe(
                (value) -> log.info(value.toString()),
                error -> log.error(error.getMessage()),
                () -> log.info("El flujo finalizó correctamente del Observable")
        );
    }

    private void mapAndFilter() {
        Flux<String> names = Flux.just("Andres", "Diego", "María", "Pedro", "Juan", "Bruce")
                .map(String::toUpperCase)
                .doOnNext(name -> {
                    if (name.isBlank()) {
                        throw new RuntimeException("Nombres no pueden ser vacíos");
                    }
                    System.out.println(name.toLowerCase());
                });

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
                    if (name.isBlank()) {
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
