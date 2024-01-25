package org.eitorresmendoza.ejemplos.tareaencontrarvuelo;

import java.util.Date;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private Date fechaHoraLlegada;
    private Integer numeroPasajeros;

    public Vuelo(String nombre, String origen, String destino, Date fechaHoraLlegada, Integer numeroPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.numeroPasajeros = numeroPasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public Integer getNumeroPasajeros() {
        return numeroPasajeros;
    }

    @Override
    public String toString() {
        return "Vuelo: " + "nombre = " + nombre + ", origen = " + origen +
                ", destino = " + destino + ", fechaHoraLlegada = " + fechaHoraLlegada +
                ", numeroPasajeros = " + numeroPasajeros;
    }
}
