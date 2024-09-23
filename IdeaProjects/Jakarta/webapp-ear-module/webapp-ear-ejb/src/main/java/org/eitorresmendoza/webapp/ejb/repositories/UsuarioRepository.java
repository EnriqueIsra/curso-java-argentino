package org.eitorresmendoza.webapp.ejb.repositories;

import org.eitorresmendoza.webapp.ejb.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> listar();
}
