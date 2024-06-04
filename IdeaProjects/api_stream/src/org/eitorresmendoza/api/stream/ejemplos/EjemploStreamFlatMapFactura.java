package org.eitorresmendoza.api.stream.ejemplos;

import org.eitorresmendoza.api.stream.ejemplos.models.Factura;
import org.eitorresmendoza.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Oscar", "Hernández");
        Usuario u2 = new Usuario("Alejandro", "Torres");
        Usuario u3 = new Usuario("coc", "icer");


        u1.addFactura(new Factura("Compra en Aurrera"));
        u1.addFactura(new Factura("Compra en Walmart"));

        u2.addFactura(new Factura("Compra en Morph wifi"));
        u2.addFactura(new Factura("Compra en la tienda en efectivo"));

        u3.addFactura(new Factura("Compra de mercancía ilegal"));

        List<Usuario> usuarios = Arrays.asList(u1, u2, u3);

        usuarios.stream()
                .flatMap(usuario -> usuario.getFacturas().stream())
                .forEach(factura -> System.out.println(factura.getUsuario().toString()
                        .concat(": ").concat(factura.getDescripcion())));

        /*for(Usuario usuario: usuarios){
            for(Factura factura: usuario.getFacturas()){
                System.out.println(factura.getDescripcion());
            }
        }*/
    }
}
