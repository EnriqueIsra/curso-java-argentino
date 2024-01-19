package org.eitorresmendoza.tareas.tarea3diagramauml;

public class JerarquiaClasesAlmacenVentaPorMayor {

    public class Producto{}
    public class ProductoAlimenticio extends Producto{}
    public class ProductoLimpieza extends Producto{}
    public class ConCaducidad extends ProductoAlimenticio{}
    public class SinCaducidad extends ProductoAlimenticio{}

    public class Persona{}
    public class Vendedor extends Persona{}
    public class Cliente extends Persona{}
}
