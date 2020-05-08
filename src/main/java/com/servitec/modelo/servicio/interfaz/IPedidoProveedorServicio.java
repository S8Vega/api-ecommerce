package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.PedidoProveedor;

public interface IPedidoProveedorServicio {
	public List<PedidoProveedor> findAll();
	
	public void save(PedidoProveedor pedidoProveedor);
	
	public PedidoProveedor findById(Long id);
	
	public void delete(PedidoProveedor pedidoProveedor);
}
