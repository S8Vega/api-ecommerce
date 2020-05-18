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
	public void crear(@RequestBody Serial serial) {
		this.serialServicio.save(serial);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Serial serial) {
		serial.setSerial_pk(id);
		this.serialServicio.save(serial);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.serialServicio.deleteById(id);
	}

}
