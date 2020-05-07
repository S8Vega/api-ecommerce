package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.Producto;

public interface IProductoServicio {
	public List<Producto> findAll();

	public void save(Producto producto);

	public Producto findById(Long id);

	public void delete(Producto producto);
}
