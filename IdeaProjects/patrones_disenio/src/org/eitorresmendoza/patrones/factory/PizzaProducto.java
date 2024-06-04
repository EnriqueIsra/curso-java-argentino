package org.eitorresmendoza.patrones.factory;

import java.util.ArrayList;
import java.util.List;

abstract public class PizzaProducto {
    protected String nombre;
    protected String masa;
    protected String salsa;
    protected List<String> ingredientes;
    public PizzaProducto(){
        this.ingredientes = new ArrayList<>();
    }
    public void prepararPizza(){
        System.out.println("nombre = " + nombre);
        System.out.println("masa = " + masa);
        System.out.println("salsa = " + salsa);
        System.out.println("ingredientes = ");
        this.ingredientes.forEach(System.out::println);
    }
    abstract public void cocinarPizza();
    abstract public void cortar();
    public void empaquetarPizza(){
        System.out.println("Empaquetando pizza");
    }
    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return "PizzaProducto{" +
                "nombre='" + nombre + '\'' +
                ", masa='" + masa + '\'' +
                ", salsa='" + salsa + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
