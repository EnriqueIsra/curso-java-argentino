package org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> listar() throws SQLException;
    List<T> porNombre(String nombre) throws SQLException;
}
