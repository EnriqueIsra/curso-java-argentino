package org.eitorresmendoza.apiservlet.webapp.cookie.repositories;

import org.eitorresmendoza.apiservlet.webapp.cookie.models.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws Exception;
}
