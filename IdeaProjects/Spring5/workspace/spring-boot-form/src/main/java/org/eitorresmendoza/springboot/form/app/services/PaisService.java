package org.eitorresmendoza.springboot.form.app.services;

import java.util.List;

import org.eitorresmendoza.springboot.form.app.models.domain.Pais;

public interface PaisService {
	public List<Pais> listar();
	public Pais obtenerPorId(Integer id);
}
