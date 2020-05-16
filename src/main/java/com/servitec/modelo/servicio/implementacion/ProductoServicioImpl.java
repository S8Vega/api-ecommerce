package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IFuncionDao;
import com.servitec.modelo.dao.interfaz.IProductoDao;
import com.servitec.modelo.entidad.Funcion;
import com.servitec.modelo.entidad.Producto;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("ProductoServicioImpl")
public class ProductoServicioImpl implements IServicio<Producto, Long> {

	@Autowired
	private IProductoDao productoDao;
	@Autowired
	private IFuncionDao funcionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) this.productoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		if (!producto.getFuncion().isEmpty()) {
			List<Funcion> funciones = (List<Funcion>) funcionDao.findAll();
			for (Funcion fp : producto.getFuncion()) {
				for (Funcion ff : funciones) {
					if (ff.getFuncion_pk().equals(fp.getFuncion_pk())) {
						ff.getProducto().add(producto);
					}
				}
			}
		}
		this.productoDao.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return this.productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		Producto producto = this.findById(id); // creo un producto
		for (Funcion f : producto.getFuncion()) {// busco todas las funciones que tenga ese producto
			for (Producto p : f.getProducto()) { // busco todos los productos de esa funcion
				if (p.getProducto_pk().equals(id)) {// si hay una funcion que contenga el producto que quiero eliminar
					f.getProducto().remove(p);// lo elimino
				}
			}
		}
		// ahora elimino todas las funciones que tenga el producto que quiero eliminar
		producto.getFuncion().removeAll(producto.getFuncion());
		this.productoDao.deleteById(id);
	}

}
