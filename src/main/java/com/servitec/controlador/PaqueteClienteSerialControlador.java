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

import com.servitec.modelo.entidad.PaqueteClienteSerial;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/paqueteClienteSerial")
public class PaqueteClienteSerialControlador {

	@Autowired
	@Qualifier("PaqueteClienteSerialServicioImpl")
	private IServicio<PaqueteClienteSerial, Long> paqueteClienteSerialServicio;

	@RequestMapping
	public List<PaqueteClienteSerial> listar() {
		return this.paqueteClienteSerialServicio.findAll();
	}

	@RequestMapping("/{id}")
	public PaqueteClienteSerial buscar(@PathVariable Long id) {
		return this.paqueteClienteSerialServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody PaqueteClienteSerial paqueteClienteSerial) {
		this.paqueteClienteSerialServicio.save(paqueteClienteSerial);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id,
			@RequestBody PaqueteClienteSerial paqueteClienteSerial) {
		paqueteClienteSerial.setPaqueteClienteSerial_pk(id);
		this.paqueteClienteSerialServicio.save(paqueteClienteSerial);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.paqueteClienteSerialServicio.deleteById(id);
	}

}
