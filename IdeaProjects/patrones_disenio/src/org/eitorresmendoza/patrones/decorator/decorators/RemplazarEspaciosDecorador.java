package org.eitorresmendoza.patrones.decorator.decorators;

import org.eitorresmendoza.patrones.decorator.Formateable;

public class RemplazarEspaciosDecorador extends TextoDecorador{
    public RemplazarEspaciosDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().replace(" ", "_");
    }
}
