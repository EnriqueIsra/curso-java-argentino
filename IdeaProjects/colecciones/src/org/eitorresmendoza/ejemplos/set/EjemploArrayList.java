package org.eitorresmendoza.ejemplos.set;

import org.eitorresmendoza.ejemplos.modelo.Alumno;

import java.util.*;


public class EjemploArrayList {
    public static void main(String[] args) {

        List<Alumno> alumnoList = new ArrayList<>();
        System.out.println(alumnoList + ", size = " + alumnoList.size());
        System.out.println("está vacía = " + alumnoList.isEmpty());

        alumnoList.add(new Alumno("Paco", 15));
        alumnoList.add(new Alumno("Sebas", 13));
        alumnoList.add(new Alumno("Juan", 55));
        alumnoList.add(2, new Alumno("Emilio", 26));
        alumnoList.set(3, new Alumno("Ronaldo", 48));

        System.out.println(alumnoList + ", size = " + alumnoList.size());

        // alumnoList.remove(new Alumno("Emilio", 25)); // no lo elimina porque no es identico
        // el alumno, esto lo realiza el método equals que valida por el nombre y la calificación el la clase Alumno
        // alumnoList.remove(new Alumno("Emilio", 26)); // si lo elimina ya que es identico al que
        // existe en el ArrayList

        alumnoList.remove(2);
        System.out.println(alumnoList + ", size = " + alumnoList.size());

        boolean boolEmilio = alumnoList.contains(new Alumno("Emilio", 26));

        boolean boolRonaldo = alumnoList.contains(new Alumno("Ronaldo", 48));
        System.out.println("La lista contiene a Emilio = " + boolEmilio);
        System.out.println("La lista contiene a Ronaldo = " + boolRonaldo);

        Object a[] = alumnoList.toArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println("Desde el arreglo: " + a[i]);
        }
        
    }
}

