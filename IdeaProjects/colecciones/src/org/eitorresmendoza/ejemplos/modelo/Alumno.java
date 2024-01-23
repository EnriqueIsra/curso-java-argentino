package org.eitorresmendoza.ejemplos.modelo;

import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
    String nombre;
    Integer numeroDeControl;

    public Alumno() {
    }

    public Alumno(String nombre, Integer numeroDeControl) {
        this.nombre = nombre;
        this.numeroDeControl = numeroDeControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroDeControl() {
        return numeroDeControl;
    }

    public void setNumeroDeControl(Integer numeroDeControl) {
        this.numeroDeControl = numeroDeControl;
    }

    @Override
    public String toString() {
        return nombre + " - calificación = " + numeroDeControl + "\n";
    }

    @Override
    public int compareTo(Alumno a) {
        if (a == null) {
            return 0;
        }
        return this.nombre.compareTo(a.nombre);

//        if (this.calificacion == a.calificacion){
//            return 0;
//        if (this.calificacion > a.calificacion){
//            return 1;
//        } else {
//            return -1;
//        }

//        if (this.numeroDeControl == null){
//            return 0;
//        }
//        return this.numeroDeControl.compareTo(a.numeroDeControl);

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Alumno alumno = (Alumno) object;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(numeroDeControl, alumno.numeroDeControl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, numeroDeControl);
    }
}
