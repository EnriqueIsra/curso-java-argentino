package org.example.eitorresmendoza.webapp.produces.factura.tarea15.models;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class Cliente {
    private String nombre;
    private String apellidos;
    private String email;

    @PostConstruct
    public void inicializar(){
        nombre = "enrique israel";
        apellidos = "torres mendoza";
        email = "elkike@kike.com";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
