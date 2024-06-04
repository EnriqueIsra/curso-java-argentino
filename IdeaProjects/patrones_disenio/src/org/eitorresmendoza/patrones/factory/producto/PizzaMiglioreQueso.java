package org.eitorresmendoza.patrones.factory.producto;

import org.eitorresmendoza.patrones.factory.PizzaProducto;

public class PizzaMiglioreQueso extends PizzaProducto {
    public PizzaMiglioreQueso() {
        super();
        nombre = "Pizza de queso migliore";
        masa = "Masa masuda pa queso";
        salsa = "Salsa de tomate de la migliore";
        ingredientes.add("Exrta queso mozarella");
        ingredientes.add("Extra queso Asadero");
        ingredientes.add("Queso blanco");
        ingredientes.add("Especies");
        ingredientes.add("Chimichurri");
    }

    @Override
    public void cocinarPizza() {
        System.out.println("Cocinando pizza bien rápido");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando0 pizza en 10 rebanadas grandes");
    }
}
