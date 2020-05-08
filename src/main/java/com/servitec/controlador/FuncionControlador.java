package com.servitec.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servitec.modelo.entidad.Funcion;
import com.servitec.modelo.servicio.interfaz.IFuncionServicio;

@RestController
@RequestMapping("/funcion")
public class FuncionControlador {

	@Autowired
	IFuncionServicio funcionServicio;
	
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
	public Funcion crear(@RequestBody Funcion funcion) {
		this.funcionServicio.save(funcion);
		return funcion;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Funcion actualizar(@PathVariable Long id, @RequestBody Funcion funcion) {
		Funcion funcionActual = this.funcionServicio.findById(id);
		funcionActual.setNombre(funcion.getNombre());
		funcionActual.setProductos(funcion.getProductos());
		this.funcionServicio.save(funcionActual);
		return funcionActual;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Funcion eliminar(@PathVariable Long id) {
		Funcion funcion = this.funcionServicio.findById(id);
		this.funcionServicio.delete(funcion);
		return funcion;
	}
	
}
