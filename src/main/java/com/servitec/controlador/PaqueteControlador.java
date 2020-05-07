package com.servitec.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return this.paqueteServicio.finAll();
	}
	
	@RequestMapping("/{id}")
	public Paquete buscar(@PathVariable long id) {
		return this.paqueteServicio.findById(id);
	}

}
