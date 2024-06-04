package org.eitorresmendoza.proyectomantenedorusuariosjdbc.repositorio;

import org.eitorresmendoza.proyectomantenedorusuariosjdbc.modelo.Usuario;
import org.eitorresmendoza.proyectomantenedorusuariosjdbc.util.ConexionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements Repositorio<Usuario> {

    private Connection getConnection() throws SQLException {
        return ConexionDataBase.getInstance();
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Statement sentencia = getConnection().createStatement();
             ResultSet rSet = sentencia.executeQuery("SELECT * FROM usuarios")) {
            while (rSet.next()) {
                Usuario u = crearUsuario(rSet);
                usuarios.add(u);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public Usuario buscarById(Long id) {
        Usuario usuario = null;
        try (PreparedStatement sentencia = getConnection()
                .prepareStatement("SELECT * FROM usuarios WHERE id = ?")) {
            sentencia.setLong(1, id);
            try (ResultSet rSet = sentencia.executeQuery()) {
                if (rSet.next()) {
                    usuario = crearUsuario(rSet);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    @Override
    public void guardar(Usuario usuario) {
        String sql;
        if (usuario.getId() != null && usuario.getId() > 0) {
            sql = "UPDATE usuarios SET username = ?, password = ?, email = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO usuarios(username, password, email) VALUES (?, ?, ?)";
        }
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, usuario.getUsername());
            sentencia.setString(2, usuario.getPassword());
            sentencia.setString(3, usuario.getEmail());
            if (usuario.getId() != null && usuario.getId() > 0) {
                sentencia.setLong(4, usuario.getId());
            }
            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void eliminar(Long id) {
        try (PreparedStatement sentencia = getConnection().prepareStatement("DELETE FROM usuarios WHERE id = ?")) {
            sentencia.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Usuario crearUsuario(ResultSet rSet) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rSet.getLong("id"));
        u.setUsername(rSet.getString("username"));
        u.setPassword(rSet.getString("password"));
        u.setEmail(rSet.getString("email"));
        return u;
    }
}
