package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.Ciudad;

public interface ICiudadServicio {
	public List<Ciudad> listar();

	public void guardar(Ciudad Ciudad);

	public Ciudad buscarId(Long id);

	public void eliminar(Long id);
}
