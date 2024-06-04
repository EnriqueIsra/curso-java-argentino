package org.eitorresmendoza.java.jdbc.repositorio;

import org.eitorresmendoza.java.jdbc.modelo.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repositorio<Categoria> {

    private Connection conexion;

    public CategoriaRepositorioImpl(Connection conexion) {
        this.conexion = conexion;
    }

    public CategoriaRepositorioImpl() {
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (Statement sentencia = conexion.createStatement();
             ResultSet resultSet = sentencia.executeQuery("SELECT * FROM categorias;")) {
            while (resultSet.next()) {
                categorias.add(crearCategoria(resultSet));
            }
        }
        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try (PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM categorias as c WHERE c.id = ?")) {
            sentencia.setLong(1, id);
            try (ResultSet resultSet = sentencia.executeQuery()) {
                if (resultSet.next()) {
                    categoria = crearCategoria(resultSet);
                }
            }
        }
        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String sql = null;
        if (categoria.getId() != null && categoria.getId() > 0) {
            sql = "UPDATE categorias SET nombre=? WHERE id=?";
        } else {
            sql = "INSERT INTO categorias(nombre) VALUES(?)";
        }
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, categoria.getNombre());
            if (categoria.getId() != null && categoria.getId() > 0) {
                stmt.setLong(2, categoria.getId());
            }
            stmt.executeUpdate();

            if (categoria.getId() == null) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        categoria.setId(rs.getLong(1));
                    }
                }
            }
        }
        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM categorias WHERE id = ?")) {
            sentencia.setLong(1, id);
            sentencia.executeUpdate();
        }
    }

    private static Categoria crearCategoria(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("id"));
        categoria.setNombre(resultSet.getString("nombre"));
        return categoria;
    }
}
