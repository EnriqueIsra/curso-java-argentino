package org.eitorresmendoza.java.jdbc.proyectomantenedorusuarios;

import org.eitorresmendoza.java.jdbc.proyectomantenedorusuarios.modelo.Usuario;
import org.eitorresmendoza.java.jdbc.proyectomantenedorusuarios.repositorio.Repositorio;
import org.eitorresmendoza.java.jdbc.proyectomantenedorusuarios.repositorio.UsuarioRepositorioImpl;
import org.eitorresmendoza.java.jdbc.proyectomantenedorusuarios.util.ConexionDataBase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MantenedorUsuariosJDBC {
    public static void main(String[] args) {
        try (Connection connection = ConexionDataBase.getInstance()) {
            Repositorio<Usuario> repositorio = new UsuarioRepositorioImpl();
            int indiceOpcion = 0;
            do {
                Map<String, Integer> operaciones = new HashMap<>();
                operaciones.put("Listar", 1);
                operaciones.put("Insertar", 2);
                operaciones.put("Modificar", 3);
                operaciones.put("Eliminar", 4);
                operaciones.put("Salir", 5);

                Object[] operacionesArreglo = operaciones.keySet().toArray();
                Object opcion = JOptionPane.showInputDialog(null,
                        "Seleccione una opción",
                        "Contenedor de usuarios", JOptionPane.INFORMATION_MESSAGE, null,
                        operacionesArreglo, operacionesArreglo[0]);
                if (opcion == null){
                    JOptionPane.showMessageDialog(null, "Se requiere seleccionar una opción");
                } else {
                    indiceOpcion = operaciones.get(opcion.toString());
                    Long id;
                    String username;
                    String password;
                    String email;

                    switch (indiceOpcion){
                        case 1 -> { // para listar
                            JOptionPane.showMessageDialog(null, "Obteniendo usuarios...");
                            repositorio.listar().forEach(System.out::println);
                        }
                        case 2 -> { // para agregar
                            username = JOptionPane.showInputDialog(null, "Ingresa el nombre del nuevo usuario");
                            password = JOptionPane.showInputDialog(null, "Ingresa la contraseña");
                            email = JOptionPane.showInputDialog(null, "Ingresa el email del usuario");

                            Usuario usuario = new Usuario();
                            usuario.setUsername(username);
                            usuario.setPassword(password);
                            usuario.setEmail(email);

                            repositorio.guardar(usuario);
                            JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente");
                        }
                        case 3 -> { // para modificar
                            id = Long.valueOf(JOptionPane.showInputDialog(null, "Ingresa el id del usuario a modificar"));

                            Usuario usuario = repositorio.buscarById(id);
                            if (usuario != null){
                                username = JOptionPane.showInputDialog(null, "Modificar nombre ", usuario.getUsername());
                                password = JOptionPane.showInputDialog(null, "Modificar contraseña ", usuario.getPassword());
                                email = JOptionPane.showInputDialog(null, "Modificar email", usuario.getEmail());

                                usuario.setUsername(username);
                                usuario.setPassword(password);
                                usuario.setEmail(email);

                                repositorio.guardar(usuario);
                                JOptionPane.showMessageDialog(null, "usuario modificado con éxito");

                            } else {
                                JOptionPane.showMessageDialog(null, "No existe el usuario con id = " + id);
                            }
                        }
                        case 4 -> { // para eliminar
                            id = Long.valueOf(JOptionPane.showInputDialog(null, "Ingresa el id del usuario a eliminar"));
                            Usuario usuario = repositorio.buscarById(id);
                            if (usuario != null){
                                repositorio.eliminar(usuario.getId());
                                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "No existe el usuario con id = " + id);
                            }
                        }
                    }
                }
            } while (indiceOpcion != 5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
