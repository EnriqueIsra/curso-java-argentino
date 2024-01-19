package org.eitorresmendoza.poointerfaces;

import org.eitorresmendoza.poointerfaces.modelo.Cliente;
import org.eitorresmendoza.poointerfaces.modelo.Producto;
import org.eitorresmendoza.poointerfaces.repositorio.AllRepositorio;
import org.eitorresmendoza.poointerfaces.repositorio.Direccion;
import org.eitorresmendoza.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        AllRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("Mesa", 350.25));
        repo.crear(new Producto("Silla", 600.90));
        repo.crear(new Producto("Lámpara", 230.0));
        repo.crear(new Producto("Teclado", 500.0));

        System.out.println("************************ Listando ************************");
        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);
        System.out.println("************************ Paginable ************************");
        List<Producto> Productospaginable = repo.listar(0, 3);
        Productospaginable.forEach(System.out::println);

        System.out.println("************************ Ordenable por Nombre Ascendente ************************");
        List<Producto> productosOrdenNombreAsc = repo.listar("descripcion", Direccion.ASC);
        for (int i = 0; i < productosOrdenNombreAsc.size(); i++) {
            System.out.println(productosOrdenNombreAsc.get(i));
        }
        System.out.println("************************ Ordenable por Apellido Ascendente ************************");
        List<Producto> productosOrdenApeAsc = repo.listar("precio", Direccion.ASC);
        for (int i = 0; i < productosOrdenApeAsc.size(); i++) {
            System.out.println(productosOrdenApeAsc.get(i));
        }
        System.out.println("************************ Ordenable por Nombre Descendente ************************");
        List<Producto> productosOrdenNombreDesc = repo.listar("descripcion", Direccion.DESC);
        for (Producto producto : productosOrdenNombreDesc) {
            System.out.println(producto);
        }
        System.out.println("************************ Ordenable por Apellido Descendente ************************");
        List<Producto> productosOrdenApeDesc = repo.listar("precio", Direccion.DESC);
        for (Producto producto : productosOrdenApeDesc) {
            System.out.println(producto);
        }
        System.out.println("************************ Editar ************************");
        Producto lamparaActualizar = new Producto("Lámpara de escritorio", 680.0);
        lamparaActualizar.setId(3);
        repo.editar(lamparaActualizar);
        Producto lamparaActualizado = repo.porId(2);
        System.out.println(lamparaActualizado);
        System.out.println("************** Lista después de editar *************");
        repo.listar("descripcion", Direccion.ASC).forEach(System.out::println);

        System.out.println("************************ Eliminar ************************");
        repo.eliminar(4);
        repo.listar().forEach(System.out::println);

        System.out.println("************************ Total Registros ************************");
        System.out.println("Total de registros: " + repo.total());
    }
}
