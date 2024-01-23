package org.eitorresmendoza.ejemplos.set;

import org.eitorresmendoza.ejemplos.modelo.Alumno;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EjemploListComparableComparator {
    public static void main(String[] args) {

        Set<Alumno> treeSetAlumno = new HashSet<>();
        //List<Alumno> treeSetAlumno = new LinkedList<>();
        treeSetAlumno.add(new Alumno("Paco", 15));
        treeSetAlumno.add(new Alumno("Sebas", 13));
        treeSetAlumno.add(new Alumno("Juan", 55));
        treeSetAlumno.add(new Alumno("Emilio", 26));
        treeSetAlumno.add(new Alumno("Ronaldo", 48));
        treeSetAlumno.add(new Alumno("Rodolfo", 42));
        treeSetAlumno.add(new Alumno("Rodolfo Dos", 42));
        treeSetAlumno.add(new Alumno("Emilio", 96));

        System.out.println("treeSetAlumno = " + treeSetAlumno);

//        System.out.println("********* Utilizando un for clásico...");
//        for (int i = 0; i < treeSetAlumno.size(); i++) {
//            Alumno a = treeSetAlumno.get(i);
//            System.out.println(a.getNombre() + " - " + a.getNumeroDeControl());
//        }

        System.out.println("********* Iterando con un foreach...");
        for (Alumno a: treeSetAlumno){
            System.out.println(a.getNombre() + " - " + a.getNumeroDeControl());
        }

        System.out.println("********* Iterando con while y el iterator...");
        Iterator<Alumno> alumnoIterator = treeSetAlumno.iterator();
        while (alumnoIterator.hasNext()){
            Alumno a = alumnoIterator.next();
            System.out.println(a.getNombre() + " - " + a.getNumeroDeControl());
        }

        System.out.println("********* Iterando con Stream forEach...");
        treeSetAlumno.forEach(System.out::println);

    }
}
