package org.eitorresmendoza.webapp.ejb.services;

import jakarta.ejb.Remote;
import org.eitorresmendoza.webapp.ejb.models.Producto;

import java.util.List;

@Remote
public interface ServiceEjbRemote {
    String saludar (String nombre);

    List<Producto> listar();
    Producto crear (Producto producto);
}
