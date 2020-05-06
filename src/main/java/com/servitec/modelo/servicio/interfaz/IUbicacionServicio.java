package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.Ubicacion;

public interface IUbicacionServicio {
	public List<Ubicacion> findAll();

	public void save(Ubicacion ubicacion);

	public Ubicacion findById(Long id);

	public void delete(Ubicacion ubicacion);
}
