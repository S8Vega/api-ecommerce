package com.servitec.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servitec.modelo.dao.interfaz.ICiudadDao;
import com.servitec.modelo.entidad.Ciudad;
import com.servitec.modelo.servicio.interfaz.ICiudadServicio;

@RestController
@RequestMapping("/ciudad")
public class CiudadControlador {

	@Autowired
	private ICiudadServicio ciudadServicio;

	@RequestMapping("/listar")
	public List<Ciudad> listar() {
		return this.ciudadServicio.listar();
	}
}
