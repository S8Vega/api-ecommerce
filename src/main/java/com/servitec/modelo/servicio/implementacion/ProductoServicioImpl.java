package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IProductoDao;
import com.servitec.modelo.entidad.Producto;
import com.servitec.modelo.servicio.interfaz.IProductoServicio;

@Service
public class ProductoServicioImpl implements IProductoServicio{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>)this.productoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		this.productoDao.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return this.productoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Producto producto) {
		this.productoDao.delete(producto);
	}

}
