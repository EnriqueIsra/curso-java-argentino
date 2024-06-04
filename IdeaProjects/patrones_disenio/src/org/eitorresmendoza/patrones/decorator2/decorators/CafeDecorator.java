package org.eitorresmendoza.patrones.decorator2.decorators;

import org.eitorresmendoza.patrones.decorator2.Configurable;

abstract public class CafeDecorator implements Configurable {
    protected Configurable cafe;

    public CafeDecorator(Configurable cafe) {
        this.cafe = cafe;
    }
}
