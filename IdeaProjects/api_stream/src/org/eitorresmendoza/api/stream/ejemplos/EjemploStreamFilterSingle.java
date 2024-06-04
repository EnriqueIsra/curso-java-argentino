package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {
    public static void main(String[] args) {
        Stream<Usuario> nombres = Stream
                .of("enrique torres","ale sanchez", "santi torres", "sebas torres")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(usuario -> usuario.getNombre().equals("santi"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();
        System.out.println(usuario.orElse(new Usuario("No existe", "este usuario")).getNombre());
        System.out.println(usuario.orElseGet(() -> new Usuario("No existe", "este usuario")).getNombre());
        if (usuario.isPresent()){
            System.out.println(usuario.get());
        } else {
            System.out.println("Este usuario no existe");
        }
        //nombres.forEach(System.out::println);
    }
}
