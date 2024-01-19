package org.eitorresmendoza.poointerfaces.tareacatalogo;

public class ProyectoCatalogo {
    public static void main(String[] args) {
        IProducto[] productos = new Producto[6];

        productos[0] = new IPhone(60000, "Apple", "Negro", "3G");
        productos[1] = new IPhone(70000, "Apple", "Blanco", "4G");
        productos[2] = new TvLcd(32000, "SONY", 36);
        productos[3] = new Libro(300, "Pepo", "Condorito", "La editorial sa de cv.");
        productos[4] = new Libro(450, "Eric Gamma", "Elementos reusables POO", "La editorial sa de cv.");
        productos[5] = new Comics(450, "Goku", "UML gota a gota", "Otra editorial", "Goku también");

        for (IProducto producto: productos){
            System.out.print("Tipo de: " + producto.getClass().getName());
            System.out.print(" - ");
            System.out.print("Precio: " + producto.getPrecio());
            System.out.print(" - ");
            System.out.print("Precio final: " + producto.getPrecioVenta());

            // Para los electrónicos --------------------------------------------
            if (producto instanceof IElectronico){
                System.out.print(" - ");
                System.out.print("Fabricante: " + ((IElectronico) producto).getFabricante());
                if (producto instanceof IPhone) {
                    System.out.print(" - ");
                    System.out.print("Modelo: " + ((IPhone) producto).getModelo());
                    System.out.print(" - ");
                    System.out.print("Color: " + ((IPhone) producto).getColor());
                }
                // Para los LCD ----------------------------------------------------
                if (producto instanceof TvLcd){
                    System.out.print(" - ");
                    System.out.print("Pulgadas: " + ((TvLcd) producto).getPulgada());
                }
            }
            // Para los libros -------------------------------------------------------
            if (producto instanceof ILibro) {
                System.out.print(" - ");
                System.out.print("Titulo: " + ((ILibro) producto).getTitulo());
                System.out.print(" - ");
                System.out.print("Autor:" + ((ILibro) producto).getAutor());
                //Para los comics -----------------------------------------------------
                if (producto instanceof Comics){
                    System.out.print(" - ");
                    System.out.print("Personaje: " + ((Comics) producto).getPersonaje());
                }
            }
            System.out.println();
        }

    }
}
