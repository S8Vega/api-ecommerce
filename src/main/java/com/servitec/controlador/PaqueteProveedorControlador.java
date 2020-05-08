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

import com.servitec.modelo.entidad.PaqueteProveedor;
import com.servitec.modelo.servicio.interfaz.IPaqueteProveedorServicio;

@RestController
@RequestMapping("/paqueteProveedor")
public class PaqueteProveedorControlador {
	
	@Autowired
	private IPaqueteProveedorServicio paqueteProveedorServico;
	
	@RequestMapping
	public List<PaqueteProveedor> listar(){
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
		PaqueteProveedor paqueteActual = this.paqueteProveedorServico.findById(id);
		paqueteActual.setPaqueteProveedor_fk(paqueteProveedor.getPaqueteProveedor_fk());
		paqueteActual.setPaqueteProveedor(paqueteProveedor.getPaqueteProveedor());
		paqueteActual.setPedidoProveedor_fk(paqueteProveedor.getPedidoProveedor_fk());
		this.paqueteProveedorServico.save(paqueteActual);
		return paqueteActual;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public PaqueteProveedor eliminar(@PathVariable Long id) {
		PaqueteProveedor paquete = this.paqueteProveedorServico.findById(id);
		return paquete;
	}
	
}
