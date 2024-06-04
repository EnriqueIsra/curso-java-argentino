package org.eitorresmendoza.patrones.factory;

import org.eitorresmendoza.patrones.factory.producto.PizzaMiglioreMexicana;
import org.eitorresmendoza.patrones.factory.producto.PizzaMigliorePepperoni;
import org.eitorresmendoza.patrones.factory.producto.PizzaMiglioreQueso;

public class PizzeriaMiglioreFactory extends PizzariaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipoPizza) {
        return switch (tipoPizza){
            case "queso" -> new PizzaMiglioreQueso();
            case "pepperoni" -> new PizzaMigliorePepperoni();
            case "mexicana" -> new PizzaMiglioreMexicana();
            default -> null;
        };
    }
}
