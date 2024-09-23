package org.eitorresmendoza.webapp.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.eitorresmendoza.webapp.ejb.entities.Usuario;
import org.eitorresmendoza.webapp.ejb.repositories.UsuarioRepository;

import java.util.List;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    private UsuarioRepository repository;
    @Override
    public List<Usuario> listar() {
        return repository.listar();
    }
}
