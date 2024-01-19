package org.eitorresmendoza.tareas.companiapersonas;

public class Persona {
    private String nombre;
    private String apellido;
    private String nuemroFiscal;
    private String direccion;

    public Persona(String nombre, String apellido, String nuemroFiscal, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nuemroFiscal = nuemroFiscal;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNuemroFiscal() {
        return nuemroFiscal;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Persona{" + "\n" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nuemroFiscal='" + nuemroFiscal + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
