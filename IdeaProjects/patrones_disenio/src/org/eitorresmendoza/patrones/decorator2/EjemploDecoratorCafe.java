package org.eitorresmendoza.patrones.decorator2;

import org.eitorresmendoza.patrones.decorator2.decorators.ConChocolateDecorator;
import org.eitorresmendoza.patrones.decorator2.decorators.ConCremaDecorator;
import org.eitorresmendoza.patrones.decorator2.decorators.ConLecheDecorator;

public class EjemploDecoratorCafe {
    public static void main(String[] args) {
        Configurable cafe = new Cafe(7, "Café Moca");
        ConCremaDecorator conCrema = new ConCremaDecorator(cafe);
        ConLecheDecorator conLeche = new ConLecheDecorator(conCrema);
        ConChocolateDecorator conChocolate = new ConChocolateDecorator(conLeche);

        System.out.println("El precio del café Moca es : " + conChocolate.getPrecioBase());
        System.out.println("Los ingredientes son: " + conChocolate.getIngredientes());

        Configurable capuchino = new Cafe(6, "Café Capuchino");
        conCrema = new ConCremaDecorator(capuchino);
        conLeche = new ConLecheDecorator(conCrema);

        System.out.println("El precio del café Capuchino es:" + conLeche.getPrecioBase());
        System.out.println("Los ingredientes son: " + conLeche.getIngredientes());

        Configurable express = new Cafe(5, "Café Express");
        System.out.println("El precio del café express es:" + express.getPrecioBase());
        System.out.println("Los ingredientes son: " + express.getIngredientes());
    }
}
