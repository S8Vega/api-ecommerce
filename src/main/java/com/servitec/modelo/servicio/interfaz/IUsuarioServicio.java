package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.Usuario;

public interface IUsuarioServicio {
	public List<Usuario> findAll();

	public void save(Usuario usuario);

	public Usuario findById(Long id);

	public void delete(Usuario usuario);
}
