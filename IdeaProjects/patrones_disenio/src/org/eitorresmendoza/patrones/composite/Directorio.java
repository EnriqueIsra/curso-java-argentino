package org.eitorresmendoza.patrones.composite;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente{

    private List<Componente> hijos;
    public Directorio(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<>();
    }

    public Componente addComponente(Componente component){
        hijos.add(component);
        return this;
    }

    public void removeComponente(Componente component){
        hijos.remove(component);
    }

    @Override
    public String mostrar(int nivel) {
        StringBuilder stringBuilder = new StringBuilder("\t".repeat(nivel));
        stringBuilder.append(nombre)
                .append("/")
                .append("\n");
        for (Componente hijo: this.hijos){
            stringBuilder.append(hijo.mostrar(nivel + 1));
            if (hijo instanceof Archivo) {
                stringBuilder.append("\n");

            }

        }
        return stringBuilder.toString();
    }

    @Override
    public boolean buscar(String nombre){
        if (this.nombre.equalsIgnoreCase(nombre)){
            return true;
        }
        /*for (Componente hijo: this.hijos){
            if (hijo.buscar(nombre)){
                return true;
            }
        }*/
        return hijos.stream().anyMatch(h -> h.buscar(nombre));
    }
}
