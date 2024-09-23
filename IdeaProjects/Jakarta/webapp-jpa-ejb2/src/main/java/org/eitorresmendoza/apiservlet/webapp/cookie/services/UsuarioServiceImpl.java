package org.eitorresmendoza.apiservlet.webapp.cookie.services;

import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.Service;
import org.eitorresmendoza.apiservlet.webapp.cookie.models.entities.Usuario;
import org.eitorresmendoza.apiservlet.webapp.cookie.repositories.RepositoryJpa;
import org.eitorresmendoza.apiservlet.webapp.cookie.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
@Stateful
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(@RepositoryJpa UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        try {
            return usuarioRepository.listar();
        } catch (Exception e) {
            throw new ServiceJdcbException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Usuario> porId(Long id) {
        try {
            return Optional.ofNullable(usuarioRepository.porId(id));
        } catch (Exception e) {
            throw new ServiceJdcbException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Usuario usuario) {
        try {
            usuarioRepository.guardar(usuario);
        } catch (Exception e) {
            throw new ServiceJdcbException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            usuarioRepository.eliminar(id);
        } catch (Exception e) {
            throw new ServiceJdcbException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (Exception throwables) {
            throw new ServiceJdcbException(throwables.getMessage(), throwables.getCause());
        }
    }
}
