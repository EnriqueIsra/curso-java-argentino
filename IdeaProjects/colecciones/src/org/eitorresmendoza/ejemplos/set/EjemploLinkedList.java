package org.eitorresmendoza.ejemplos.set;

import org.eitorresmendoza.ejemplos.modelo.Alumno;

import java.util.LinkedList;


public class EjemploLinkedList {
    public static void main(String[] args) {

        LinkedList<Alumno> alumnoLinkedList = new LinkedList<>();
        System.out.println(alumnoLinkedList + ", size = " + alumnoLinkedList.size());
        System.out.println("está vacía = " + alumnoLinkedList.isEmpty());

        alumnoLinkedList.add(new Alumno("Paco", 15));
        alumnoLinkedList.add(new Alumno("Sebas", 13));
        alumnoLinkedList.add(new Alumno("Juan", 55));
        alumnoLinkedList.add(new Alumno("Emilio", 26));
        alumnoLinkedList.add(new Alumno("Ronaldo", 48));

        System.out.println(alumnoLinkedList + ", size = " + alumnoLinkedList.size());

        alumnoLinkedList.addFirst(new Alumno("Zeus", 86));
        alumnoLinkedList.addLast(new Alumno("Atena", 28));

        System.out.println(alumnoLinkedList + ", size = " + alumnoLinkedList.size());

        System.out.println("Primer elemento = " + alumnoLinkedList.getFirst());
        System.out.println("Último elemento = " + alumnoLinkedList.getLast());
        System.out.println("Elemento en la posición 2 = " + alumnoLinkedList.get(2));

        //Para eliminar en una LinkedList
        // Alumno zeus = alumnoLinkedList.pop(); // este elimina al inicio
        // alumnoLinkedList.pollLast(); // este elimina al final
        // equivalentes...
        alumnoLinkedList.removeFirst();
        alumnoLinkedList.removeLast();
        System.out.println(alumnoLinkedList + ", size = " + alumnoLinkedList.size());

        alumnoLinkedList.remove();
        System.out.println(alumnoLinkedList + ", size = " + alumnoLinkedList.size());

        Alumno elLucas = new Alumno("Lucas", 45);
        alumnoLinkedList.addLast(elLucas);
        System.out.println("Indice de lucas: " +alumnoLinkedList.indexOf(elLucas));

        alumnoLinkedList.remove(2);
        System.out.println(alumnoLinkedList + ", size = " + alumnoLinkedList.size());
        System.out.println("Indice de lucas: " +alumnoLinkedList.indexOf(elLucas));

        alumnoLinkedList.set(3,new Alumno("Eduard", 32));
        System.out.println(alumnoLinkedList + ", size = " + alumnoLinkedList.size());

    }
}

