package org.eitorresmendoza.optional.ejemplo;

import org.eitorresmendoza.optional.ejemplo.models.Computador;
import org.eitorresmendoza.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.eitorresmendoza.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();
        Computador pc = repositorio.filtrar("PLATA")
                .orElseThrow(IllegalStateException::new);
        System.out.println(pc);

        String archivo = "documento.pdf";
        String extension = Optional.ofNullable("documento.pdf")
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();
        System.out.println(extension);

    }
}
