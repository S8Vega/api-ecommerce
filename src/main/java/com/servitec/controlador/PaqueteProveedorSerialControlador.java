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
	public PaqueteProveedorSerial crear(@RequestBody PaqueteProveedorSerial paqueteProveedorSerial) {
		this.paqueteProveedorSerialServicio.save(paqueteProveedorSerial);
		return paqueteProveedorSerial;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public PaqueteProveedorSerial actualizar(@PathVariable Long id,
			@RequestBody PaqueteProveedorSerial paqueteProveedorSerial) {
		PaqueteProveedorSerial paqueteProveedorSerialActual = this.paqueteProveedorSerialServicio.findById(id);
		paqueteProveedorSerialActual.setPaqueteProveedor_fk(paqueteProveedorSerial.getPaqueteProveedor_fk());
		paqueteProveedorSerialActual.setSerial_fk(paqueteProveedorSerial.getSerial_fk());
		this.paqueteProveedorSerialServicio.save(paqueteProveedorSerialActual);
		return paqueteProveedorSerialActual;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public PaqueteProveedorSerial eliminar(@PathVariable Long id) {
		PaqueteProveedorSerial paqueteProveedorSerial = this.paqueteProveedorSerialServicio.findById(id);
		this.paqueteProveedorSerialServicio.delete(paqueteProveedorSerial);
		return paqueteProveedorSerial;
	}

}
