package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.Paquete;

public interface IPaqueteServicio {
	public List<Paquete> findAll();
	
	public void save(Paquete paquete);
	
	public Paquete findById(Long id);
	
	public void delete(Paquete paquete);
}
