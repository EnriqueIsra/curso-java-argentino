package org.eitorresmendoza.patrones.factory;

abstract public class PizzariaZonaAbstractFactory {
    public PizzaProducto ordenarPizza(String tipoPizza){
        PizzaProducto pizza = crearPizza(tipoPizza);
        System.out.println("--------- Fabricando la pizza " + pizza.getNombre() + " ----------");
        pizza.prepararPizza();
        pizza.cocinarPizza();
        pizza.cortar();
        pizza.empaquetarPizza();
        return pizza;
    }
    abstract PizzaProducto crearPizza(String tipoPizza);
}
