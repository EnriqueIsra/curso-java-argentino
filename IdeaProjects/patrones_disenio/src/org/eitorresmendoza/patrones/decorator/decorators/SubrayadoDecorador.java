package org.eitorresmendoza.patrones.decorator.decorators;

import org.eitorresmendoza.patrones.decorator.Formateable;

public class SubrayadoDecorador extends TextoDecorador{
    public SubrayadoDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        int largo = texto.darFormato().length();
        StringBuilder stringBuilder = new StringBuilder(texto.darFormato());
        stringBuilder.append("\n");
        for (int i = 0; i < largo; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}

