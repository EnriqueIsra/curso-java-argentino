package org.eitorresmendoza.ejemplos.set;

import org.eitorresmendoza.ejemplos.modelo.Alumno;

import static java.util.Comparator.comparing;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {

        // Set<Alumno> treeSetAlumno = new TreeSet<>(/*(a, b) -> a.getNumeroDeControl().compareTo(b.getNumeroDeControl())*/);
        Set<Alumno> treeSetAlumno = new TreeSet<>(comparing(Alumno::getNumeroDeControl).reversed());
        treeSetAlumno.add(new Alumno("Paco", 15));
        treeSetAlumno.add(new Alumno("Sebas", 13));
        treeSetAlumno.add(new Alumno("Juan", 55));
        treeSetAlumno.add(new Alumno("Emilio", 26));
        treeSetAlumno.add(new Alumno("Ronaldo", 48));
        treeSetAlumno.add(new Alumno("Rodolfo", 42));

        System.out.println("treeSetAlumno = " + treeSetAlumno);

    }
}
