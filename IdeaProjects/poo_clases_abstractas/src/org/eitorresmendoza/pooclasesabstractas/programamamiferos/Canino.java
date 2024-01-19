package org.eitorresmendoza.pooclasesabstractas.programamamiferos;

abstract public class Canino extends Mamifero {
    protected String color;
    protected float tamanioColmillos;

    public Canino(String habitat, float altura, float largo, float peso,
                  String color, float tamanioColmillos){
        super(habitat, altura, largo, peso);
        this.color = color;
        this.tamanioColmillos = tamanioColmillos;
    }
}
