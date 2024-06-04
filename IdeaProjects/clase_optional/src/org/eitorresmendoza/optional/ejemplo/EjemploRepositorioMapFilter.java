package org.eitorresmendoza.optional.ejemplo;

import org.eitorresmendoza.optional.ejemplo.models.Computador;
import org.eitorresmendoza.optional.ejemplo.models.Fabricante;
import org.eitorresmendoza.optional.ejemplo.models.Procesador;
import org.eitorresmendoza.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.eitorresmendoza.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        String f = repositorio.filtrar("acer")
                .flatMap(Computador::getProcesador)
                .flatMap(Procesador::getFabricante)
                .filter(fab -> "intel".equalsIgnoreCase(fab.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");
        System.out.println(f);

    }
}
