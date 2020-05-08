package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.PaqueteProveedor;

public interface IPaqueteProveedorServicio {
	public List<PaqueteProveedor> findAll();
	
	public void save(PaqueteProveedor paqueteProveedor);
	
	public PaqueteProveedor findById(Long id);
	
	public void delete(PaqueteProveedor paqueteProveedor);

}
