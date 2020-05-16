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

@Service("FuncionServicioImpl")
public class FuncionServicioImpl implements IServicio<Funcion, Long> {

	@Autowired
	private IFuncionDao funcionDao;
	@Autowired
	private IProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Funcion> findAll() {
		return (List<Funcion>) this.funcionDao.findAll();
	}

	@Override
	@Transactional
	public void save(Funcion funcion) {
		if (!funcion.getProducto().isEmpty()) {
			List<Producto> productos = (List<Producto>) productoDao.findAll();
			for (Producto pf : funcion.getProducto()) {
				for (Producto pp : productos) {
					if (pf.getProducto_pk().equals(pp.getProducto_pk())) {
						pp.getFuncion().add(funcion);
					}
				}
			}
		}
		this.funcionDao.save(funcion);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcion findById(Long id) {
		return this.funcionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		Funcion funcion = this.findById(id); // creo una funcion
		for (Producto p : funcion.getProducto()) { // busco todos los productos de esa funcion
			for (Funcion f : p.getFuncion()) { // busco las funciones que tenga ese producto
				if (f.getFuncion_pk().equals(id)) { // si hay un producto que contenga la funcion que quiero eliminar
					p.getFuncion().remove(f); // la elimino
				}
			}
		}
		// ahora elimino todos los productos que tenga la funcion que quiero eliminar
		funcion.getProducto().removeAll(funcion.getProducto());
		this.funcionDao.deleteById(id);
	}

}
