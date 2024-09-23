package org.eitorresmendoza.apiservlet.webapp.cookie.services;

import org.eitorresmendoza.apiservlet.webapp.cookie.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();
    Optional<Usuario> porId(Long id);
    void guardar(Usuario usuario);
    void eliminar(Long id);
    Optional<Usuario> login(String username, String password);
}
