package org.eitorresmendoza.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscandoDuplicado2 {
    public static void main(String[] args) {
        String[] peces = {"Corvina", "Lenguado", "Pejerrey", "Robalo", "Atún", "Lenguado", "Atún"};

        Set<String> elementosNODuplicados = new HashSet<>();
        Set<String> elementosDuplicados = new HashSet<>();
        for (String elPezDuplicado : peces){
            if (!elementosNODuplicados.add(elPezDuplicado)){
                elementosDuplicados.add(elPezDuplicado);
            }
        }
        elementosNODuplicados.removeAll(elementosDuplicados);
        System.out.println(elementosNODuplicados.size() + " elementos no duplicados: " + elementosNODuplicados);
        System.out.println(elementosDuplicados.size() + " elementos duplicados: " + elementosDuplicados);
    }
}
