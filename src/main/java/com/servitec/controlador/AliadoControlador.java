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

import com.servitec.modelo.entidad.Aliado;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/aliado")
public class AliadoControlador {

	@Autowired
	@Qualifier("AliadoServicioImpl")
	private IServicio<Aliado, Long> aliadoServicio;

	@RequestMapping
	public List<Aliado> listar() {
		return this.aliadoServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Aliado buscar(@PathVariable Long id) {
		return this.aliadoServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Aliado aliado) {
		this.aliadoServicio.save(aliado);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Aliado aliado) {
		aliado.setAliado_pk(id);
		this.aliadoServicio.save(aliado);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.aliadoServicio.deleteById(id);
	}

}
