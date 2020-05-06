package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.Ciudad;

public interface ICiudadServicio {
	public List<Ciudad> findAll();
	
	public void save(Ciudad ciudad);
	
	public Ciudad findById(Long id);
	
	public void delete(Ciudad ciudad);
}
