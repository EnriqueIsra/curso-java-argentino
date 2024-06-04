package org.eitorresmendoza.optional.ejemplo.repositorio;

import org.eitorresmendoza.optional.ejemplo.models.Computador;
import org.eitorresmendoza.optional.ejemplo.models.Fabricante;
import org.eitorresmendoza.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador> {

    private List<Computador> dataSource;
    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        Procesador procesador = new Procesador("Intel CORE I5", new Fabricante("Intel"));
        Computador acer = new Computador("Acer roja", "Aspire 5");
        acer.setProcesador(procesador);
        dataSource.add(acer);
        dataSource.add(new Computador("Lenovo plata", "Touch"));
    }
    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream()
                .filter(computador -> computador.getNombre().toLowerCase()
                        .contains(nombre.toLowerCase()))
                .findFirst();
        /*for (Computador computador: dataSource){
            if (computador.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(computador);
            }
        }
        return Optional.empty();*/
    }


}
