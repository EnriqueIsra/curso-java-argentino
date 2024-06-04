package org.eitorresmendoza.patrones.factory.producto;

import org.eitorresmendoza.patrones.factory.PizzaProducto;

public class PizzaDominossHawaiana extends PizzaProducto {
    public PizzaDominossHawaiana() {
        super();
        nombre = "Pizza Hawaiana de Dominoss";
        masa = "Masa de hawai";
        salsa = "Salsa de tomate hawaiana";
        ingredientes.add("Extra queso");
        ingredientes.add("Mucho jamón");
        ingredientes.add("Mucha piña asada");
    }

    @Override
    public void cocinarPizza() {
    System.out.println("Cocinando pizza por 30 min a 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando pizza en rebanadas cuadradas grandes");
    }
}
