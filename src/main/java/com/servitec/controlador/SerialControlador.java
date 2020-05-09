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


import com.servitec.modelo.entidad.Serial;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("serial")
public class SerialControlador {
    
	@Autowired
	@Qualifier("SerialServicioImpl")
	private IServicio<Serial, Long> serialServicio;
	
	@RequestMapping
	public List<Serial> listar() {
		return this.serialServicio.findAll();
	}
	
	@RequestMapping("/{id}")
	public Serial buscar(@PathVariable Long id) {
		return this.serialServicio.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Serial crear(Serial serial) {
		this.serialServicio.save(serial);
		return serial;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Serial actualizar(@PathVariable Long id, @RequestBody Serial serial) {
		Serial actual = this.serialServicio.findById(id);
		actual.setControlCalidad(serial.getControlCalidad());
		actual.setMetodoEntrada(serial.getMetodoEntrada());
		return actual;
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public Serial eliminar(@PathVariable Long id) {
		Serial serial = this.serialServicio.findById(id);
		this.serialServicio.delete(serial);
		return serial;
	}
	
}
