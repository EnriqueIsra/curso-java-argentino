package org.eitorresmendoza.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscandoDuplicado {
    public static void main(String[] args) {
        String[] peces = {"Corvina", "Lenguado", "Pejerrey", "Robalo", "Atún", "Lenguado", "Atún"};

        Set<String> elementosNoDuplicados = new HashSet<>();
        for (String elPezDuplicado : peces){
            if (!elementosNoDuplicados.add(elPezDuplicado)){
                System.out.println("Elemento duplicado: " + elPezDuplicado);
            }
        }
        System.out.println(elementosNoDuplicados.size() + " elementos únicos: " + elementosNoDuplicados);
    }
}
