package org.eitorresmendoza.patrones.decorator.decorators;

import org.eitorresmendoza.patrones.decorator.Formateable;

public class ReversaDecorador extends TextoDecorador{
    public ReversaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        StringBuilder stringBuilder = new StringBuilder(texto.darFormato());
        return stringBuilder.reverse().toString();
    }
}
