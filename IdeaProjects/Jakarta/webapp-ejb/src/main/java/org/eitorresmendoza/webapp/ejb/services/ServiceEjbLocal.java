package org.eitorresmendoza.webapp.ejb.services;

import jakarta.ejb.Local;
import org.eitorresmendoza.webapp.ejb.models.Producto;

import java.util.List;

@Local
public interface ServiceEjbLocal {
    String saludar (String nombre);

    List<Producto> listar();
    Producto crear (Producto producto);
}