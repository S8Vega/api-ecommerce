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

import com.servitec.modelo.entidad.PedidoProveedor;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/pedidoProveedor")
public class PedidoProveedorControlador {

	@Autowired
	@Qualifier("PedidoProveedorServicioImpl")
	private IServicio<PedidoProveedor, Long> pedServicio;

	@RequestMapping
	public List<PedidoProveedor> listar() {
		return this.pedServicio.findAll();
	}

	@RequestMapping("/{id}")
	public PedidoProveedor buscar(@PathVariable Long id) {
		return this.pedServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody PedidoProveedor pedidoProveedor) {
		this.pedServicio.save(pedidoProveedor);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody PedidoProveedor pedidoProveedor) {
		pedidoProveedor.setPedidoProveedor_pk(id);
		this.pedServicio.save(pedidoProveedor);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.pedServicio.deleteById(id);
	}
}
