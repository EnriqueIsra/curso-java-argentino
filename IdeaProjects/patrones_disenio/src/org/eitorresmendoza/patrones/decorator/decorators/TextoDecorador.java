package org.eitorresmendoza.patrones.decorator.decorators;

import org.eitorresmendoza.patrones.decorator.Formateable;

public abstract class TextoDecorador implements Formateable {
    protected Formateable texto;

    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}
