package org.eitorresmendoza.patrones.decorator2.decorators;

import org.eitorresmendoza.patrones.decorator2.Configurable;

public class ConLecheDecorator extends CafeDecorator{
    public ConLecheDecorator(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 4f;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes() + ", Leche";
    }
}
