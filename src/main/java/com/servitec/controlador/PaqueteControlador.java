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

import com.servitec.modelo.entidad.Paquete;
import com.servitec.modelo.servicio.interfaz.IPaqueteServicio;


@RestController
@RequestMapping("/paquete")
public class PaqueteControlador {
	
	@Autowired
	private IPaqueteServicio paqueteServicio;
	
	@RequestMapping
	public List<Paquete> listar(){
		return this.paqueteServicio.findAll();
	}
	
	@RequestMapping("/{id}")
	public Paquete buscar(@PathVariable long id) {
		return this.paqueteServicio.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Paquete crear(@RequestBody Paquete paquete) {
		this.paqueteServicio.save(paquete);
		return paquete;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Paquete actualizar(@PathVariable Long id, @RequestBody Paquete paquete) {
		Paquete paqueteActual = this.paqueteServicio.findById(id);
		paqueteActual.setCantidadInicial(paquete.getCantidadInicial());
		paqueteActual.setMedida(paquete.getMedida());
		paqueteActual.setPaquete_pk(paquete.getPaquete_pk());
		paqueteActual.setProducto_fk(paquete.getProducto_fk());
		this.paqueteServicio.save(paqueteActual);
		return paqueteActual;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Paquete eliminar(@PathVariable Long id) {
		Paquete paquete = this.paqueteServicio.findById(id);
		this.paqueteServicio.delete(paquete);
		return paquete;
	}

}
