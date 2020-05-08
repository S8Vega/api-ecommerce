package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.PedidoCliente;

public interface IPedidoClienteServicio {
	public List<PedidoCliente> findAll();
	
	public void save(PedidoCliente pedidoCliente);
	
	public PedidoCliente findById(Long id);
	
	public void delete(PedidoCliente pedidoCliente);
}
