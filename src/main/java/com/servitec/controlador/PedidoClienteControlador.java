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

import com.servitec.modelo.entidad.PedidoCliente;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/pedidoCliente")
public class PedidoClienteControlador {

	@Autowired
	@Qualifier("PedidoClienteServicioImpl")
	private IServicio<PedidoCliente, Long> pedidoServicio;

	@RequestMapping
	public List<PedidoCliente> listar() {
		return this.pedidoServicio.findAll();
	}

	@RequestMapping("/{id}")
	public PedidoCliente buscar(@PathVariable Long id) {
		return this.pedidoServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody PedidoCliente pedidoCliente) {
		this.pedidoServicio.save(pedidoCliente);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody PedidoCliente pedidoCliente) {
		pedidoCliente.setPedidoCliente_pk(id);
		this.pedidoServicio.save(pedidoCliente);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.pedidoServicio.deleteById(id);
	}

}
