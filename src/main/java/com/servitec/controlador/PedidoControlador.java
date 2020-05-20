package com.servitec.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servitec.modelo.entidad.Pedido;
import com.servitec.modelo.servicio.implementacion.PedidoServicioImpl;

@RestController
@RequestMapping("pedido")
public class PedidoControlador {

	@Autowired
	private PedidoServicioImpl pedidoServicio;

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
	public void crear(@RequestBody Pedido pedido) {
		this.pedidoServicio.save(pedido);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
		pedido.setPedido_pk(id);
		System.out.println(pedido.getCodigo());
		this.pedidoServicio.save(pedido);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.pedidoServicio.deleteById(id);
	}

	@RequestMapping("/recibido/{id}")
	public ResponseEntity<?> recibido(@PathVariable Long id) {
		return this.pedidoServicio.recibido(id);
	}

	@RequestMapping("/devolucion/{id}")
	public Map<String, Object> devolucion(@PathVariable Long id) {
		return this.pedidoServicio.devolucion(id);
	}

}
