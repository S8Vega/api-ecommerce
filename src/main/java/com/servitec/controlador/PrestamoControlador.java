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

import com.servitec.modelo.entidad.Prestamo;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("prestamo")
public class PrestamoControlador {

	@Autowired
	@Qualifier("PrestamoServicioImpl")
	private IServicio<Prestamo, Long> prestamoServicio;

	@RequestMapping
	public List<Prestamo> listar() {
		return this.prestamoServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Prestamo buscar(@PathVariable Long id) {
		return this.prestamoServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Prestamo prestamo) {
		this.prestamoServicio.save(prestamo);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Prestamo prestamo) {
		prestamo.setPrestamo_pk(id);
		this.prestamoServicio.save(prestamo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.prestamoServicio.deleteById(id);
	}
}
