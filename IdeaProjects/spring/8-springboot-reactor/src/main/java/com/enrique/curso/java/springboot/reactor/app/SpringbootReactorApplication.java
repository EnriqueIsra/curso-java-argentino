package com.enrique.curso.java.springboot.reactor.app;

import com.enrique.curso.java.springboot.reactor.app.models.Comments;
import com.enrique.curso.java.springboot.reactor.app.models.User;
import com.enrique.curso.java.springboot.reactor.app.models.UserComments;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringbootReactorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringbootReactorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        intervalFromCreate();
    }
    private void intervalFromCreate() {
        Flux.create(emitter -> {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                private Integer counter = 0;
                @Override
                public void run() {
                    emitter.next(++counter);
                    /* if (counter.equals(10)){
                        timer.cancel();
                        emitter.complete();
                    } */
                    if (counter.equals(10)) {
                        timer.cancel();
                        emitter.error(new InterruptedException("Error, se ah detenido el flux"));
                    }
                }
            },1000, 1000);
        })
                .doOnTerminate(() -> log.info("Hemos terminado..."))
                .retry(2)
                .subscribe(next -> log.info(next.toString()),
                        error -> log.error(error.getMessage()),
                        () -> log.info("Hemos terminado correctamente..."));
    }

    private void intervalInfinite() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Flux.interval(Duration.ofSeconds(1))
                .doOnTerminate(countDownLatch::countDown)
                .flatMap(value -> {
                    if (value == 5) {
                        return Flux.error(new InterruptedException("Solo hasta 5"));
                    }
                    return Flux.just(value);
                })
                .map(i -> "Hola ".concat(i.toString()))
                .retry(2)
                .subscribe(log::info, error -> log.error(error.getMessage()));
        countDownLatch.await();
    }

    private void delayElements() throws InterruptedException {
        CountDownLatch counter = new CountDownLatch(1);
        Flux<Integer> range = Flux.range(1, 12)
                .delayElements(Duration.ofSeconds(2))
                .doOnNext(value -> log.info(value.toString()))
                .doOnTerminate(counter::countDown);
        range.subscribe();
        counter.await();

        // TimeUnit.SECONDS.sleep(26);
        // Thread.sleep(26000);
    }
    private void interval() {
        Flux<Integer> range = Flux.range(1, 12);
        Flux<Long> delay =Flux.interval(Duration.ofSeconds(1));
        range.zipWith(delay, (first, second) -> first)
                .doOnNext(value -> log.info(value.toString()))
                .blockLast();
    }

    private void zipRange () {
        Flux<Integer> range = Flux.range(1, 5);
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);

        numbers.map(integer -> integer * 2)
                .zipWith(range, (first, second) ->
                        String.format("Primer flux: %d, Segundo flux: %d", first, second))
                .subscribe(log::info);
    }

    private void userCommentsWithZip2(){
        Mono<User> userMono = Mono.fromCallable(this::createUser);
        Mono<Comments> commentsMono = Mono.fromCallable(() -> {
            Comments comments = new Comments();
            comments.addComment("Hola soy el Sebitas cómo están?");
            comments.addComment("Mañana nos vamos a la playa mi familia y yo");
            comments.addComment("Mi papá está en la sección de spring boot con reactor");
            return comments;
        });

        Mono<UserComments> userCommentsMono = userMono
                .zipWith(commentsMono)
                        // .map(tupla -> new UserComments(tupla.getT1(), tupla.getT2())); // o ...
                        .map(tupla -> {
                            User user = tupla.getT1();
                            Comments comments = tupla.getT2();
                            return new UserComments(user, comments);
                        });
        userCommentsMono.subscribe(System.out::println);
    }

    private void userCommentsWithZip(){
        Mono<User> userMono = Mono.fromCallable(this::createUser);
        Mono<Comments> commentsMono = Mono.fromCallable(() -> {
            Comments comments = new Comments();
            comments.addComment("Hola soy el Sebitas cómo están?");
            comments.addComment("Mañana nos vamos a la playa mi familia y yo");
            comments.addComment("Mi papá está en la sección de spring boot con reactor");
            return comments;
        });

        Mono<UserComments> userCommentsMono = userMono.zipWith(
                commentsMono, UserComments::new
        );
        userCommentsMono.subscribe(System.out::println);
    }
    
    private void userCommentsFlatMap() {
        Mono<User> userMono = Mono.fromCallable(this::createUser);
        Mono<Comments> commentsMono = Mono.fromCallable(() -> {
            Comments comments = new Comments();
            comments.addComment("Hola soy el Sebitas cómo están?");
            comments.addComment("Mañana nos vamos a la playa mi familia y yo");
            comments.addComment("Mi papá está en la sección de spring boot con reactor");
            return comments;
        });

        Mono<UserComments> userCommentsMono = userMono
                .flatMap(user -> commentsMono
                        .flatMap(comments -> Mono.fromCallable(() -> new UserComments(user, comments))));

        userCommentsMono.subscribe(userComments -> log.info(userComments.toString()));
    }

    private User createUser() {
        return new User("Alejandro", "Torres");
    }

    private void collectList(){
        List<User> userList = Arrays.asList(
                new User("Alejandra", "Sánchez"),
                new User("Enrique", "Mendoza"),
                new User("Santiago", "Torres"),
                new User("Sebastian", "Torres"),
                new User("Samuel",  "Torres")
        );
        Mono<List<User>> names = Flux.fromIterable(userList)
//                .flatMap(user -> Mono.just(user.getName().concat(" ").concat(user.getLastname())))
                .collectList();
        names.subscribe(list -> list.forEach(System.out::println));

    }

    private void flatMapToString() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Alejandra", "Sánchez"));
        userList.add(new User("Enrique", "Mendoza"));
        userList.add(new User("Santiago", "Torres"));
        userList.add(new User("Sebastian", "Torres"));
        userList.add(new User("Samuel",  "Torres"));

        Flux.fromIterable(userList)
                .flatMap(user -> Mono.just(user.getName().concat(" ").concat(user.getLastname())))
                .flatMap(user -> {
                    if (user.toLowerCase().contains("torres")){
                        return Mono.just(user);
                    }
                    return Mono.empty();
                })
                .map(String::toUpperCase).subscribe(log::info);
    }

    private void flatMap() {
        List<String> userList = new ArrayList<>();
        userList.add("Alejandra Sánchez");
        userList.add("Enrique Mendoza");
        userList.add("Santiago Torres");
        userList.add("Sebastian Torres");
        userList.add("Samuel Mendoza");

        Flux<String> names = Flux.fromIterable(userList);

        Flux<User> users = names.map(name -> {
                    String[] parts = name.split("\\s+");
                    return new User(parts[0], parts[1]);
                })
                .flatMap(user -> {
                    if (user.getLastname().equalsIgnoreCase("mendoza")){
                        return Mono.just(user);
                    }
                    return Mono.empty();
                })
                .map(user -> {
                    String lastnameUpperCase = user.getLastname().toUpperCase();
                    user.setLastname(lastnameUpperCase);
                    user.setCreatedAt(LocalDateTime.now());
                    return user;
                });

        users.subscribe(
                (user) -> log.info(user.toString())
        );
    }

    private void fromIterable() {
        List<String> userList = new ArrayList<>();
        userList.add("Alejandra Sánchez");
        userList.add("Enrique Mendoza");
        userList.add("Santiago Torres");
        userList.add("Sebastian Torres");
        userList.add("Samuel Mendoza");

        Flux<String> names = Flux.fromIterable(userList);

        Flux<User> users = names.map(String::trim)
                .doOnNext(name -> {
                    System.out.println("Validando que ni el nombre ni el apellido sean vacíos...");
                    String[] parts = name.split("\\s+");

                    if (name.isBlank() || parts.length < 2) {
                        throw new RuntimeException("Nombres ni Apellidos no pueden ser vacíos");
                    }
                })
                .map(name -> {
                    String[] parts = name.split("\\s+");
                    return new User(parts[0], parts[1]);
                })
                .filter(user -> user.getLastname().equalsIgnoreCase("mendoza"))
                .doOnNext(name -> {
                    System.out.println("-> Filtrando por apellido que sea igual a mendoza");
                })
                .doOnNext(System.out::println)
                .doOnNext(name -> {
                    System.out.println("-> Apellido se convierte a MAYUSCULA y se asigna una fecha de creación");
                })
                .map(user -> {
                    String lastnameUpperCase = user.getLastname().toUpperCase();
                    user.setLastname(lastnameUpperCase);
                    user.setCreatedAt(LocalDateTime.now());
                    return user;
                })
                .doOnNext(System.out::println);

        System.out.println("***********************");
        System.out.println("Lista de nombres Flux<String>");

        System.out.println("***********************");
        System.out.println("Lista de usuarios Flux<User>");
        users.subscribe(
                (user) -> log.info(user.toString()),
                error -> log.error(error.getMessage()),
                () -> log.info("El flujo finalizó correctamente del Observable")
        );
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
                    System.out.println("Validando que ni el nombre ni el apellido sean vacíos...");
                    String[] parts = name.split("\\s+");

                    if (name.isBlank() || parts.length < 2) {
                        throw new RuntimeException("Nombres ni Apellidos no pueden ser vacíos");
                    }
                })
                .map(name -> {
                    String[] parts = name.split("\\s+");
                    return new User(parts[0], parts[1]);
                })
                .doOnNext(name -> {
                    System.out.println("-> Filtrando por apellido con 7 letras de longitud");
                })
                .filter((user) -> user.getLastname().length() == 7)
                .doOnNext(System.out::println)
                .filter(user -> user.getLastname().equalsIgnoreCase("mendoza"))
                .doOnNext(name -> {
                    System.out.println("-> Filtrando por apellido que sea igual a mendoza");
                })
                .doOnNext(System.out::println)
                .doOnNext(name -> {
                    System.out.println("-> Apellido se convierte a MAYUSCULA y se asigna una fecha de creación");
                })
                .map(user -> {
                    String lastnameUpperCase = user.getLastname().toUpperCase();
                    user.setLastname(lastnameUpperCase);
                    user.setCreatedAt(LocalDateTime.now());
                    return user;
                })
                .doOnNext(System.out::println);

        System.out.println("***********************");
        System.out.println("Lista de nombres Flux<String>");
        names.subscribe(System.out::println);

        System.out.println("***********************");
        System.out.println("Lista de usuarios Flux<User>");
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
