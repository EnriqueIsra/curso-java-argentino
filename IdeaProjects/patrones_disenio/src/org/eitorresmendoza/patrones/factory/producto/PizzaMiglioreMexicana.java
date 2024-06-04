package org.eitorresmendoza.patrones.factory.producto;

import org.eitorresmendoza.patrones.factory.PizzaProducto;

public class PizzaMiglioreMexicana extends PizzaProducto {

    public PizzaMiglioreMexicana() {
        super();
        nombre = "Pizza mexicana de Migliore";
        masa = "Masa rica Migliore";
        salsa = "Salsa de tomate Migliore";
        ingredientes.add("Extra queso mozarella");
        ingredientes.add("Chiles jalapeños asados");
        ingredientes.add("Chorizo ranchero");
        ingredientes.add("Mucho jamón");
    }

    @Override
    public void cocinarPizza() {
        System.out.println("Cocinando a 90°C por 25 minutos");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando pizza en 10 rebanadas triangulares");
    }
}
