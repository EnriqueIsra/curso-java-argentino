package org.enriquetorres.app.hogar;

import java.security.PublicKey;

public class Persona {
    private String nombre;
    private String apellido;
    private ColorCabello colorCabello;
    public static final String GENERO_MASCULINO = "Masculino";
    public static final String GENERO_FEMENINO = "Femenino";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ColorCabello getColorCabello() {
        return colorCabello;
    }

    public void setColorCabello(ColorCabello colorCabello) {
        this.colorCabello = colorCabello;
    }

    public String lanzarPelota(){
        return "Lanza la pelota al perro!";
    }
    public static String saludar(){
        return "Hola que tal";
    }
}
