package org.eitorresmendoza.java.jdbc.repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {
    void setConexion(Connection conexion);
    List<T> listar() throws SQLException;
    T porId(Long id) throws SQLException;
    T guardar(T t) throws SQLException;
    void eliminar(Long id) throws SQLException;
}
