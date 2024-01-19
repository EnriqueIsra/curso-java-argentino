package org.eitorresmendoza.carrosupermercado;

public class TareaBolsaSuperMercadoGenerics {
    public static void main(String[] args) {

        // Creando y nombrando las bolsas de los diferentes tipos de productos, instanciando la clase de tipo generica BolsaSuperMercado
        BolsaSuperMercado<Fruta> laBolsaDeFrutas = new BolsaSuperMercado<>();
        BolsaSuperMercado<Lacteo> laBolsaDeProductosLacteos = new BolsaSuperMercado<>();
        BolsaSuperMercado<Limpieza> laBolsaDeProductosDeLimpieza = new BolsaSuperMercado<>();
        BolsaSuperMercado<SinCaducidad> laBolsaDeProductosSinCaducidad = new BolsaSuperMercado<>();

        // Añadir elementos o frutas a la bolsa de frutas, (la clase BolsaSuperMercado contiene el método para agregar o añadir
        // productos de cualquier tipo (método addProducto))
        //
        // Añadimos el nuevo producto con el operador new y haciendo referencia a la clase del producto que va a agregar.
        laBolsaDeFrutas.addProducto(new Fruta("Melon", 32.0, 3.2,
                "Cafecito claro, como el color de la arena por fuera, naranja claro por dentro, semillas blancas"));
        laBolsaDeFrutas.addProducto(new Fruta("Sandía", 45.0, 7.5,
                "Verde rayada por fuera, roja por dentro, semillas negras"));
        laBolsaDeFrutas.addProducto(new Fruta("Manzana", 4.5, 7.4,
                "Hay rojas, verdes y amarillas por fuera, pero todas son como blanquitas por dentro y con semillas como negras o cafeces"));
        laBolsaDeFrutas.addProducto(new Fruta("Mango", 5.5, 9.6,
                "Naranjita o amarillo e incluso un poco colorado por fuera, por dentro amarillo y el hueso también"));
        laBolsaDeFrutas.addProducto(new Fruta("Uva", 6.1, 12.5,
                "Hay verdes y moradas, por dentro son como transparentes y las semillas son negras, cafe oscuro o claro"));

        // añadiendo elementos a la bolsa de lácteos
        laBolsaDeProductosLacteos.addProducto(new Lacteo("Leche entera", 40.0, 15, 200));
        laBolsaDeProductosLacteos.addProducto(new Lacteo("Queso asadero", 108.0, 3, 400));
        laBolsaDeProductosLacteos.addProducto(new Lacteo("Crema", 38.0, 4, 275));
        laBolsaDeProductosLacteos.addProducto(new Lacteo("Yogurt de durazno", 45.0, 2, 150));
        laBolsaDeProductosLacteos.addProducto(new Lacteo("Queso fresco", 36.0, 2, 350));

        // añadiendo elementos a la bolsa de limpieza
        laBolsaDeProductosDeLimpieza.addProducto(new Limpieza("Salvo", 29.80, "limón y hierbabuena", 20.0));
        laBolsaDeProductosDeLimpieza.addProducto(new Limpieza("Desengrasante", 130.45, "desengrasante y aromatizante", 15.0));
        laBolsaDeProductosDeLimpieza.addProducto(new Limpieza("Pinol", 45.20, "desinfectante y aromatizante", 35.0));
        laBolsaDeProductosDeLimpieza.addProducto(new Limpieza("Suavitel", 180.90, "suavizante y aromatizante de telas", 30.0));
        laBolsaDeProductosDeLimpieza.addProducto(new Limpieza("Jabón líquido para ropa", 167.50, "quita manchas y aromatizante para telas", 20.0));

        // añadir elementos a la bolsa de productos sin caducidad
        laBolsaDeProductosSinCaducidad.addProducto(new SinCaducidad("Chiles jalapeños", 80.0, 3500, 600));
        laBolsaDeProductosSinCaducidad.addProducto(new SinCaducidad("Atun", 40.0, 400, 450));
        laBolsaDeProductosSinCaducidad.addProducto(new SinCaducidad("Frijoles", 20.0, 1000, 550));
        laBolsaDeProductosSinCaducidad.addProducto(new SinCaducidad("Arroz", 32.0, 1500, 400));
        laBolsaDeProductosSinCaducidad.addProducto(new SinCaducidad("Frijoles negros", 22.0, 1000, 500));

        // implementamos un for para cada una de las bolsas
        System.out.println("********************** La bolsa de frutas ***********************");
        for (Fruta fruta: laBolsaDeFrutas.getProductos()){
            System.out.println("--------------------------");
            System.out.println("Nombre: " + fruta.getNombre());
            System.out.println("Precio: " + fruta.getPrecio());
            System.out.println("Peso (gr): " + fruta.getPeso());
            System.out.println("Color: " + fruta.getColor());
        }
        System.out.println("********************** La bolsa de productos lácteos ***********************");
        for (Lacteo lacteo: laBolsaDeProductosLacteos.getProductos()){
            System.out.println("--------------------------");
            System.out.println("Nombre: " + lacteo.getNombre());
            System.out.println("Precio: " + lacteo.getPrecio());
            System.out.println("Cantidad (gr): " + lacteo.getCantidad());
            System.out.println("Proteínas (gr): " + lacteo.getProteinas());
        }
        System.out.println("********************** La bolsa de productos de limpieza ***********************");
        for (Limpieza limpieza: laBolsaDeProductosDeLimpieza.getProductos()){
            System.out.println("--------------------------");
            System.out.println("Nombre: " + limpieza.getNombre());
            System.out.println("Precio: " + limpieza.getPrecio());
            System.out.println("Componentes: " + limpieza.getComponentes());
            System.out.println("Litros: " + limpieza.getLitros());
        }
        System.out.println("********************** La bolsa de productos sin fecha de caducidad ***********************");
        for (SinCaducidad sinCaducidad: laBolsaDeProductosSinCaducidad.getProductos()){
            System.out.println("--------------------------");
            System.out.println("Nombre: " + sinCaducidad.getNombre());
            System.out.println("Precio: " + sinCaducidad.getPrecio());
            System.out.println("Contenido (gr): " + sinCaducidad.getContenido());
            System.out.println("Calorías (Kcal): " + sinCaducidad.getCalorias());
        }
    }
}
