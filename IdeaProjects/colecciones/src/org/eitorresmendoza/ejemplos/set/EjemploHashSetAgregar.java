package org.eitorresmendoza.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        System.out.println(hashSet.add("uno"));
        System.out.println(hashSet.add("dos"));
        System.out.println(hashSet.add("tres"));
        System.out.println(hashSet.add("cuatro"));
        System.out.println(hashSet.add("cinco"));

        boolean agregarElementosRepetidos = hashSet.add("tres");
        System.out.println("agregarElementosRepetidos = " + agregarElementosRepetidos);
        System.out.println("hashSet = " + hashSet);
    }

}
