package com.servitec.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servitec.modelo.entidad.Producto;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {

	@Autowired
	@Qualifier("ProductoServicioImpl")
	private IServicio<Producto, Long> productoServicio;

	@RequestMapping
	public List<Producto> listar() {
		return this.productoServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Producto buscar(@PathVariable Long id) {
		return this.productoServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Producto producto) {
		this.productoServicio.save(producto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Producto producto) {
		producto.setProducto_pk(id);
		this.productoServicio.save(producto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.productoServicio.deleteById(id);
	}
}
