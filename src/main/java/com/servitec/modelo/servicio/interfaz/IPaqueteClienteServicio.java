package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.PaqueteCliente;

public interface IPaqueteClienteServicio {
	public List<PaqueteCliente> findAll();
	
	public void save(PaqueteCliente paqueteCliente);
	
	public PaqueteCliente findById(Long id);
	
	public void delete(PaqueteCliente paqueteCliente);
}
