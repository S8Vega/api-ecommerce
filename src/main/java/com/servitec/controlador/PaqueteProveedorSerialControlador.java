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

import com.servitec.modelo.entidad.PaqueteProveedorSerial;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/paqueteProveedorSerial")
public class PaqueteProveedorSerialControlador {

	@Autowired
	@Qualifier("PaqueteProveedorSerialServicioImpl")
	private IServicio<PaqueteProveedorSerial, Long> paqueteProveedorSerialServicio;

	@RequestMapping
	public List<PaqueteProveedorSerial> listar() {
		return this.paqueteProveedorSerialServicio.findAll();
	}

	@RequestMapping("/{id}")
	public PaqueteProveedorSerial buscar(@PathVariable Long id) {
		return this.paqueteProveedorSerialServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody PaqueteProveedorSerial paqueteProveedorSerial) {
		this.paqueteProveedorSerialServicio.save(paqueteProveedorSerial);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody PaqueteProveedorSerial paqueteProveedorSerial) {
		paqueteProveedorSerial.setPaqueteProveedorSerial_pk(id);
		this.paqueteProveedorSerialServicio.save(paqueteProveedorSerial);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.paqueteProveedorSerialServicio.deleteById(id);
	}

}
