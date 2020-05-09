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
	public Producto crear(@RequestBody Producto producto) {
		this.productoServicio.save(producto);
		return producto;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
		Producto productoActual = this.productoServicio.findById(id);
		productoActual.setCantidadMinima(producto.getCantidadMinima());
		productoActual.setFunciones(producto.getFunciones());
		productoActual.setMarca(producto.getMarca());
		productoActual.setModelo(producto.getModelo());
		productoActual.setNombre(producto.getNombre());
		productoActual.setUbicacion(producto.getUbicacion());
		this.productoServicio.save(productoActual);
		return productoActual;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Producto eliminar(@PathVariable Long id) {
		Producto producto = this.productoServicio.findById(id);
		this.productoServicio.delete(producto);
		return producto;
	}
}
