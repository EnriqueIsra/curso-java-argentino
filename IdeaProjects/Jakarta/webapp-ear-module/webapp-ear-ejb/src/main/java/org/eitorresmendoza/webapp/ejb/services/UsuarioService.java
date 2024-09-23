package org.eitorresmendoza.webapp.ejb.services;

import jakarta.ejb.Local;
import org.eitorresmendoza.webapp.ejb.entities.Usuario;

import java.util.List;

@Local
public interface UsuarioService {
    List<Usuario> listar();
}
