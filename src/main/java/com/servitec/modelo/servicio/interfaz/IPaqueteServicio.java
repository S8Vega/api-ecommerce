package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.Paquete;

public interface IPaqueteServicio {
	public List<Paquete> finAll();
	
	public void savr(Paquete paquete);
	
	public Paquete findById(Long id);
	
	public void delete(Paquete paquete);
}
