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

import com.servitec.modelo.entidad.Funcion;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/funcion")
public class FuncionControlador {

	@Autowired
	@Qualifier("FuncionServicioImpl")
	IServicio<Funcion, Long> funcionServicio;

	@RequestMapping
	public List<Funcion> listar() {
		return this.funcionServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Funcion buscar(@PathVariable Long id) {
		return this.funcionServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Funcion funcion) {
		this.funcionServicio.save(funcion);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Funcion funcion) {
		funcion.setFuncion_pk(id);
		this.funcionServicio.save(funcion);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.funcionServicio.deleteById(id);
	}

}
