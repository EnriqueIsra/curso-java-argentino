package org.eitorresmendoza.ejemplos.set;

import org.eitorresmendoza.ejemplos.modelo.Alumno;

import java.util.*;
import static java.util.Comparator.comparing;


public class EjemploListComparableComparator {
    public static void main(String[] args) {

        List<Alumno> alumnoList = new ArrayList<>();
        System.out.println(alumnoList + ", size = " + alumnoList.size());
        System.out.println("está vacía = " + alumnoList.isEmpty());

        alumnoList.add(new Alumno("Paco", 15));
        alumnoList.add(new Alumno("Sebas", 13));
        alumnoList.add(new Alumno("Juan", 55));
        alumnoList.add(new Alumno("Paco", 15));
        alumnoList.add(new Alumno("Sebas", 13));
        alumnoList.add(new Alumno("Juan", 55));

        // Collections.sort(alumnoList, (a, b) -> b.getNumeroDeControl().compareTo(a.getNumeroDeControl()));
        alumnoList.sort((a, b) -> a.getNumeroDeControl().compareTo(b.getNumeroDeControl()));
        alumnoList.sort(comparing(Alumno::getNombre).reversed());

        System.out.println("Iterando con un Stream forEach");
        alumnoList.forEach(System.out::println);

    }
}

