package org.eitorresmendoza.tareas.almacenyverduleria;

public class TareaAlmacenFruteria {
    public static void main(String[] args) {
        Producto[] productos = new Producto[8];

        productos[0] = new Lacteo("Leche de mis bouas", 50, 100, 1150);
        productos[1] = new Lacteo("Queso asadero", 65, 65, 1650);
        productos[2] = new Fruta("Jitomate", 30, 15, "rojo");
        productos[3] = new Fruta("Chile poblano", 45, 20, "Verde oscuro");
        productos[4] = new Limpieza("Jabón Savlo", 42, "Limón y Hierba buena", 30);
        productos[5] = new Limpieza("Suavitel", 39, "Aroma y suavizante de telas", 45);
        productos[6] = new NoPerecible("Atún", 35, 350, 1200);
        productos[7] = new NoPerecible("Chiles jalapeños", 25, 200, 950);

        for (Producto producto: productos){
            System.out.println("*************" + producto.getClass().getSimpleName() + "**************");
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());

            if (producto instanceof Lacteo){
                System.out.println("Cantidad (gr/cc): " + ((Lacteo) producto).getCantidad());
                System.out.println("Proteínas (gr): " + ((Lacteo) producto).getProteinas());
            } else if (producto instanceof Fruta) {
                System.out.println("Peso (gr): " + ((Fruta) producto).getPeso());
                System.out.println("Color: " + ((Fruta) producto).getColor());
            } else if (producto instanceof Limpieza) {
                System.out.println("Componentes: " + ((Limpieza) producto).getComponentes());
                System.out.println("Litros: " + ((Limpieza) producto).getLitros());
            } else if (producto instanceof NoPerecible) {
                System.out.println("Calorías (kCal): " + ((NoPerecible) producto).getCalorias());
                System.out.println("Contenido Neto (gr): " + ((NoPerecible) producto).getContenido());
            }
        }
    }
}
