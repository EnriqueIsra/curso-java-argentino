package org.eitorresmendoza.optional.ejemplo;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {
        String nombre = "Enrique";
        Optional<String> opt = Optional.of(nombre);
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        if (opt.isPresent()){
            System.out.println("Hola " + nombre);
        }
        System.out.println(opt.isEmpty());
        opt.ifPresent(value -> System.out.println("Hola " + value));

        nombre = null;
        opt = Optional.ofNullable(nombre);
        System.out.println(opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        opt.ifPresentOrElse(value -> System.out.println("Hola " + value),
                () -> System.out.println("El elemento no está presente"));

        if (opt.isPresent()) {
            System.out.println("Hola " + nombre);
        } else {
            System.out.println("El elemento no está presente");
        }

        Optional<String> optEmpty = Optional.empty();
        System.out.println("optEmpty = " + optEmpty);
        System.out.println(optEmpty.isPresent());
    }
}
