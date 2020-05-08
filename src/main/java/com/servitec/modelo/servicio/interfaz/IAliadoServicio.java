package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.Aliado;

public interface IAliadoServicio {
	public List<Aliado> findAll();
	
	public void save(Aliado aliado);
	
	public Aliado findById(Long id);
	
	public void delete(Aliado aliado);
}
