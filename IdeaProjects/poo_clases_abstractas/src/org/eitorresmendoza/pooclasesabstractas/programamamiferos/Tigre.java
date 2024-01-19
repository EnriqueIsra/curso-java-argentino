package org.eitorresmendoza.pooclasesabstractas.programamamiferos;

public class Tigre extends Felino {

    private String especieTigre;

    public Tigre(String habitat, float altura, float largo, float peso, float tamanioGarras, int velocidad,
                 String especieTigre) {
        super(habitat, altura, largo, peso, tamanioGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    public String getEspecieTigre() {
        return especieTigre;
    }

    @Override
    public String toString() {
        return "Tigre{" +
                "especieTigre='" + especieTigre + '\'' +
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
    public String comer(){
        return "Dieta: El tigre " + especieTigre +"caza solitario en los manglares y bosques de " + habitat;
    }
    @Override
    public String dormir(){
        return "Descanso: El tigre " + especieTigre + " duerme en las selvas de " + habitat;
    }
    @Override
    public String correr(){
        return "Velocidad: El tigre" + especieTigre + " corre a una velocidad de" + velocidad + "km/h";
    }
    @Override
    public String comunicarse(){
        return "Comunicación: El Tigre ruge y agacha sus orejas";
    }
}

