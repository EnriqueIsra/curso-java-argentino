package org.eitorresmendoza.patrones.decorator2.decorators;

import org.eitorresmendoza.patrones.decorator2.Configurable;

public class ConChocolateDecorator extends CafeDecorator{
    public ConChocolateDecorator(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 5f;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes() + ", Chocolate";
    }
}
