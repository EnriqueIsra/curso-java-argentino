package org.eitorresmendoza.optional.ejemplo;

import org.eitorresmendoza.optional.ejemplo.models.Computador;
import org.eitorresmendoza.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.eitorresmendoza.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();
        repositorio.filtrar("PLATA").ifPresentOrElse(System.out::println,
                () -> System.out.println("No existe"));

        /*Optional<Computador> pc = repositorio.filtrar("acer");

        if (pc.isPresent()){
            System.out.println(pc.get() );
        } else {
            System.out.println("No existe");
        }*/
    }
}
