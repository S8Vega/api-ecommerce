package com.servitec.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Prueba {

	@RequestMapping("/")	
	public String mensaje() {
		return "hola mundo";
	}
}
