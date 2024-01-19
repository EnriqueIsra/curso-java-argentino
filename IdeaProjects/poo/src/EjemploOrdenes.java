import java.util.Date;

public class EjemploOrdenes {
    public static void main(String[] args) {
        OrdenCompra orden1 = new OrdenCompra("Compras componentes pc");
        orden1.setCliente(new Cliente("Enrique", "Torres"));
        orden1.setFecha(new Date());
        orden1.addProducto(new Producto("JBL", "Audifonos Gamer", 2500));
        orden1.addProducto(new Producto("SONY", "Audifonos Gamer 2", 2500));
        orden1.addProducto(new Producto("JBL", "Audifonos Gamer 3", 2500));
        orden1.addProducto(new Producto("LG", "Audifonos Gamer 4", 2500));

        OrdenCompra orden2 = new OrdenCompra("Compra mandadillo");
        orden2.setCliente(new Cliente("Santiago", "Torres"));
        orden2.setFecha(new Date());
        orden2.addProducto(new Producto("Sabritas", "Doritos", 35));
        orden2.addProducto(new Producto("Lala", "Leche", 39));
        orden2.addProducto(new Producto("Regio", "Papel higiénico", 130));
        orden2.addProducto(new Producto("Carta Blanca", "Carta Blanca six", 60));

        OrdenCompra orden3 = new OrdenCompra("Compra ropa");
        orden3.setCliente(new Cliente("Xander", "Hernández"));
        orden3.setFecha(new Date());
        orden3.addProducto(new Producto("Nike", "Playera Nike SB", 350));
        orden3.addProducto(new Producto("Puma", "Tenis bibis and bathed", 3900));
        orden3.addProducto(new Producto("Adidas", "Sudadera Adidas verde cian", 1300));
        orden3.addProducto(new Producto("Nike", "Calzones premium", 600));

        OrdenCompra[] ordenes = {orden1, orden2, orden3};

        for (OrdenCompra orden: ordenes){
            System.out.println("Folio: " + orden.getIdentificador());
            System.out.println("Cliente: " + orden.getCliente());
            System.out.println("Descripción: " + orden.getDescripcion());
            System.out.println("Fecha: " + orden.getFecha());
            System.out.println("Total: " + orden.getGranTotal());

            int i = 1;
            for (Producto p: orden.getProductos()){
                System.out.println("Producto: " + i + ": " + p.getNombre() + " " + p.getFabricante() + " precio $" + p.getPrecio());
                i++;
            }
            System.out.println("----------------SIGUIENTE-----------------");
        }
    }
}
