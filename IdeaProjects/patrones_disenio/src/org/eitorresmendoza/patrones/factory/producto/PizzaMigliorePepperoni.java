package org.eitorresmendoza.patrones.factory.producto;

import org.eitorresmendoza.patrones.factory.PizzaProducto;

public class PizzaMigliorePepperoni extends PizzaProducto {
    public PizzaMigliorePepperoni() {
        super();
        nombre = "Pizza de pepperoni migliore";
        masa = "Masa masuda pa pepperoni";
        salsa = "Salsa de tomate de la migliore";
        ingredientes.add("Exrta queso mozarella");
        ingredientes.add("Extra queso Asadero");
        ingredientes.add("Queso blanco");
        ingredientes.add("Especies");
        ingredientes.add("Chimichurri");
        ingredientes.add("Extra pepperoni");
    }

    @Override
    public void cocinarPizza() {
        System.out.println("Cocinando pizza bien rica");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando0 pizza en 18 rebanadas grandes");
    }
}

