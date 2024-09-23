package org.eitorresmendoza.apiservlet.webapp.cookie.repositories;

import org.eitorresmendoza.apiservlet.webapp.cookie.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws SQLException;
}
