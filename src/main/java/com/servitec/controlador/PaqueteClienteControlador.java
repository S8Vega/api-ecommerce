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

import com.servitec.modelo.entidad.PaqueteCliente;
import com.servitec.modelo.servicio.interfaz.IPaqueteClienteServicio;

@RestController
@RequestMapping("/paqueteCliente")
public class PaqueteClienteControlador {
	
	@Autowired
	private IPaqueteClienteServicio paqueteClienteServicio;
	
	@RequestMapping
	public List<PaqueteCliente> listar(){
		return this.paqueteClienteServicio.findAll();
	}
	
	@RequestMapping("/{id}")
	public PaqueteCliente buscar(@PathVariable Long id) {
		return this.paqueteClienteServicio.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public PaqueteCliente actualizar(@PathVariable Long id,@RequestBody PaqueteCliente paqueteCliente) {
		PaqueteCliente paqueteActual = this.paqueteClienteServicio.findById(id);
		paqueteActual.setPaquete_fk(paqueteCliente.getPaquete_fk());
		paqueteActual.setPaqueteCliente_pk(paqueteCliente.getPaqueteCliente_pk());
		paqueteActual.setPedidoCliente(paqueteCliente.getPedidoCliente());
		return paqueteActual;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public PaqueteCliente eliminar(@PathVariable Long id) {
		PaqueteCliente paquete = this.paqueteClienteServicio.findById(id);
		return paquete;
	}
	
}
