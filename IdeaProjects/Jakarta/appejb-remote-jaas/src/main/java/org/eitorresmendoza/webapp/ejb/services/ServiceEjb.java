package org.eitorresmendoza.webapp.ejb.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import org.eitorresmendoza.webapp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

@DeclareRoles({"USER", "ADMIN"})
@Stateful
public class ServiceEjb implements ServiceEjbRemote {

    private int contador;

    @RolesAllowed({"ADMIN", "USER"})
    public String saludar (String nombre) {
        System.out.println("imprimiendo dentro del ejb con instancia: " + this);
        contador ++;
        System.out.println("valor del contador del metodo saludar: " + contador);
        return "Hola que tal " + nombre;
    }

    @RolesAllowed({"ADMIN", "USER"})
    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("peras"));
        productos.add(new Producto("manzanas"));
        productos.add(new Producto("naranjas"));
        return productos;
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public Producto crear(Producto producto) {
        System.out.println("guardando producto... " + producto);
        Producto p = new Producto();
        p.setNombre(producto.getNombre());
        return p;
    }
}
