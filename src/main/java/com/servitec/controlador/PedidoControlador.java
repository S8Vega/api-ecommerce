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

import com.servitec.modelo.entidad.Pedido;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("pedido")
public class PedidoControlador {

	@Autowired
	@Qualifier("PedidoServicioImpl")
	private IServicio<Pedido, Long> pedidoServicio;

	@RequestMapping
	public List<Pedido> listar() {
		return this.pedidoServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Pedido buscar(@PathVariable Long id) {
		return this.pedidoServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(Pedido pedido) {
		this.pedidoServicio.save(pedido);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
		pedido.setPedido_pk(id);
		this.pedidoServicio.save(pedido);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.pedidoServicio.deleteById(id);
	}

}
