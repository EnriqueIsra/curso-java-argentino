package org.eitorresmendoza.patrones.factory.producto;

import org.eitorresmendoza.patrones.factory.PizzaProducto;

public class PizzaDominossVegetariana extends PizzaProducto {
    public PizzaDominossVegetariana() {
        super();
        nombre = "Pizza vegetariana de Dominoss";
        masa = "Masa integral vegana";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Berenjenas");
    }

    @Override
    public void cocinarPizza() {
        System.out.println("Cocinando por 25 minutos a 150°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando pizza en rebanadas cuadradas");
    }
}
