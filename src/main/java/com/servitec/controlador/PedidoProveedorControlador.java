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

import com.servitec.modelo.entidad.PedidoProveedor;
import com.servitec.modelo.entidad.Usuario;
import com.servitec.modelo.servicio.interfaz.IPedidoProveedorServicio;

@RestController
@RequestMapping("/pedidoProveedor")
public class PedidoProveedorControlador {

		@Autowired
		private IPedidoProveedorServicio pedServicio;
		
		@RequestMapping
		public List<PedidoProveedor> listar(){
			return this.pedServicio.findAll();
		}
		
		@RequestMapping("*{id}")
		public PedidoProveedor buscar(@PathVariable Long id) {
			return this.pedServicio.findById(id);
		}
		
		@RequestMapping(method = RequestMethod.POST)
		@ResponseStatus(value = HttpStatus.CREATED)
		public PedidoProveedor crear(@RequestBody PedidoProveedor pedidoProveedor) {
			this.pedServicio.save(pedidoProveedor);
			return pedidoProveedor;
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		@ResponseStatus(value = HttpStatus.CREATED)
		public PedidoProveedor actualizar(@PathVariable Long id, @RequestBody PedidoProveedor pedidoProveedor) {
			PedidoProveedor pedAct = this.pedServicio.findById(id);
			pedAct.setPedidoProveedor(pedidoProveedor.getPedidoProveedor());
			pedAct.setProveedor_fk(pedidoProveedor.getProveedor_fk());
			this.pedServicio.save(pedAct);
			return pedAct;
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public PedidoProveedor eliminar(@PathVariable Long id) {
			PedidoProveedor pedidoProveedor = this.pedServicio.findById(id);
			this.pedServicio.delete(pedidoProveedor);
			return pedidoProveedor;
		}
}
