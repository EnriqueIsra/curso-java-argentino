package org.eitorresmendoza.pooclasesabstractas.programamamiferos;

import java.util.PrimitiveIterator;

public class Leon extends Felino {

    private int numManada;
    private float potenciaRugido;

    public Leon(String habitat, float altura, float largo, float peso,
                float tamanioGarras, int velocidad, int numManada, float potenciaRugido) {
        super(habitat, altura, largo, peso, tamanioGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugido = potenciaRugido;
    }

    public int getNumManada() {
        return numManada;
    }

    public float getPotenciaRugido() {
        return potenciaRugido;
    }

    @Override
    public String toString() {
        return "Leon{" +
                "numManada=" + numManada +
                ", potenciaRugido=" + potenciaRugido +
                ", tamanioGarras=" + tamanioGarras +
                ", velocidad=" + velocidad +
                ", habitat='" + habitat + '\'' +
                ", altura=" + altura +
                ", largo=" + largo +
                ", peso=" + peso +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                '}' + "\n";
    }

    @Override
    public String comer() {
        return "Dieta: El león caza junto con su manada de " + numManada + " individuos " + "en las llanuras africanas";
    }

    @Override
    public String dormir() {
        return "Descanso: El león duerme en las estepas africanas";
    }

    @Override
    public String correr() {
        return "Velocidad: El león puede llegar a correr a una velocidad de hasta " + velocidad + "km/h";
    }

    @Override
    public String comunicarse() {
        return "Comunicación: El león ruge fuerte, a una potencia de " + potenciaRugido + " decibeles";
    }
}
