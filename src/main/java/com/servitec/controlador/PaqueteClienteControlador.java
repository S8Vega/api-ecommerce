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

import com.servitec.modelo.entidad.PaqueteCliente;

import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/paqueteCliente")
public class PaqueteClienteControlador {

	@Autowired
	@Qualifier("PaqueteClienteServicioImpl")
	private IServicio<PaqueteCliente, Long> paqueteClienteServicio;

	@RequestMapping
	public List<PaqueteCliente> listar() {
		return this.paqueteClienteServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public PaqueteCliente crear(@RequestBody PaqueteCliente paqueteCliente) {
		this.paqueteClienteServicio.save(paqueteCliente);
		return paqueteCliente;
	}

	@RequestMapping("/{id}")
	public PaqueteCliente buscar(@PathVariable Long id) {
		return this.paqueteClienteServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public PaqueteCliente actualizar(@PathVariable Long id, @RequestBody PaqueteCliente paqueteCliente) {
		PaqueteCliente paqueteClienteActual = (PaqueteCliente) this.paqueteClienteServicio.findById(id);
		paqueteClienteActual.setPaquete_fk(paqueteCliente.getPaquete_fk());
		paqueteClienteActual.setPaqueteClienteSerial(paqueteCliente.getPaqueteClienteSerial());
		paqueteClienteActual.setPedidoCliente_fk(paqueteCliente.getPedidoCliente_fk());
		this.paqueteClienteServicio.save(paqueteClienteActual);
		return paqueteClienteActual;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public PaqueteCliente eliminar(@PathVariable Long id) {
		PaqueteCliente paqueteClienteActual = (PaqueteCliente) this.paqueteClienteServicio.findById(id);
		this.paqueteClienteServicio.delete(paqueteClienteActual);
		return paqueteClienteActual;
	}

}
