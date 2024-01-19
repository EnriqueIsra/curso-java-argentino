package org.eitorres.appfacturas;

import org.eitorres.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("123456");
        cliente.setNombre("Enrique");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una descripción de la factura: ");
        Factura factura = new Factura(scanner.nextLine(), cliente);

        Producto producto;
        System.out.println();

        for (int i = 0; i < 2; i++){
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getCodigo() + ": ");
            producto.setNombre(scanner.nextLine());

            System.out.print("Ingrese el precio: ");

            producto.setPrecio(scanner.nextFloat());

            System.out.print("Ingrese la cantidad; ");
            factura.additemFactura(new ItemFactura(scanner.nextInt(), producto));

            System.out.println();
            scanner.nextLine();
        }
        System.out.println(factura.generarDetalle());
    }

}
