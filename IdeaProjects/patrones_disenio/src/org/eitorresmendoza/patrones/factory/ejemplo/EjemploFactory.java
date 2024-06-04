package org.eitorresmendoza.patrones.factory.ejemplo;

import org.eitorresmendoza.patrones.factory.PizzaProducto;
import org.eitorresmendoza.patrones.factory.PizzariaZonaAbstractFactory;
import org.eitorresmendoza.patrones.factory.PizzeriaDominossFactory;
import org.eitorresmendoza.patrones.factory.PizzeriaMiglioreFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzariaZonaAbstractFactory dominoss = new PizzeriaDominossFactory();
        PizzariaZonaAbstractFactory migliore = new PizzeriaMiglioreFactory();

        PizzaProducto pizza = migliore.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza" + pizza.getNombre());
        pizza = dominoss.ordenarPizza("pepperoni");
        System.out.println("Andrés ordena una " + pizza.getNombre());

        pizza = migliore.ordenarPizza("mexicana");
        System.out.println("Santi pide una pizza " + pizza.getNombre());

        pizza = dominoss.ordenarPizza("vegetariana");
        System.out.println("Alguien pidió una " + pizza.getNombre());

        pizza = migliore.ordenarPizza("pepperoni");
        System.out.println("Yo pedi una de " + pizza.getNombre());

        System.out.println("pizza = " + pizza);
    }
}
