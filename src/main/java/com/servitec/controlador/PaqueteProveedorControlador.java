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

import com.servitec.modelo.entidad.PaqueteProveedor;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/paqueteProveedor")
public class PaqueteProveedorControlador {

	@Autowired
	@Qualifier("PaqueteProveedorServicioImpl")
	private IServicio<PaqueteProveedor, Long> paqueteProveedorServico;

	@RequestMapping
	public List<PaqueteProveedor> listar() {
		return this.paqueteProveedorServico.findAll();
	}

	@RequestMapping("/{id}")
	public PaqueteProveedor buscar(@PathVariable Long id) {
		return this.paqueteProveedorServico.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public PaqueteProveedor crear(@RequestBody PaqueteProveedor paqueteProveedor) {
		this.paqueteProveedorServico.save(paqueteProveedor);
		return paqueteProveedor;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public PaqueteProveedor actualizar(@PathVariable Long id, @RequestBody PaqueteProveedor paqueteProveedor) {
		PaqueteProveedor paqueteProveedorActual = this.paqueteProveedorServico.findById(id);
		paqueteProveedorActual.setPaquete_fk(paqueteProveedor.getPaquete_fk());
		paqueteProveedorActual.setPedidoProveedor_fk(paqueteProveedor.getPedidoProveedor_fk());
		this.paqueteProveedorServico.save(paqueteProveedorActual);
		return paqueteProveedorActual;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public PaqueteProveedor eliminar(@PathVariable Long id) {
		PaqueteProveedor paquete = this.paqueteProveedorServico.findById(id);
		this.paqueteProveedorServico.delete(paquete);
		return paquete;
	}

}
