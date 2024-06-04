package org.eitorresmendoza.patrones.factory;

import org.eitorresmendoza.patrones.factory.producto.PizzaDominossHawaiana;
import org.eitorresmendoza.patrones.factory.producto.PizzaDominossPeperoni;
import org.eitorresmendoza.patrones.factory.producto.PizzaDominossVegetariana;

public class PizzeriaDominossFactory extends PizzariaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipoPizza) {

        return switch (tipoPizza) {
            case "hawaiana" -> new PizzaDominossHawaiana();
            case "pepperoni" -> new PizzaDominossPeperoni();
            case "vegetariana" -> new PizzaDominossVegetariana();
            default -> null;
        };
    }
}
