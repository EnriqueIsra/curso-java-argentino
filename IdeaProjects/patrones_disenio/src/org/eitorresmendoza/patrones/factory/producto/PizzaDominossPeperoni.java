package org.eitorresmendoza.patrones.factory.producto;

import org.eitorresmendoza.patrones.factory.PizzaProducto;

public class PizzaDominossPeperoni extends PizzaProducto {
    public PizzaDominossPeperoni() {
        super();
        nombre = "Pizza Peperoni de Dominoss";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Extra peperoni");
    }

    @Override
    public void cocinarPizza() {
        System.out.println("Cocinado por 40 minutos a 90°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando pizza en rebanadas triangulares");
    }
}
