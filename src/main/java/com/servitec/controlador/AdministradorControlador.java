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

import com.servitec.modelo.entidad.Administrador;
import com.servitec.modelo.servicio.implementacion.AdministradorServicioImpl;

@RestController
@RequestMapping("/administrador")
public class AdministradorControlador {

	@Autowired
	private AdministradorServicioImpl administradorServicio;

	@RequestMapping
	public List<Administrador> listar() {
		return this.administradorServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Administrador administrador) {
		this.administradorServicio.save(administrador);
	}

	@RequestMapping("/{id}")
	public Administrador buscar(@PathVariable Long id) {
		return this.administradorServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Administrador administrador) {
		administrador.setAdministrador_pk(id);
		this.administradorServicio.save(administrador);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.administradorServicio.deleteById(id);
	}

}
