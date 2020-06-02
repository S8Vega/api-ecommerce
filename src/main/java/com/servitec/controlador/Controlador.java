package com.servitec.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
	@RequestMapping
	public String listar() {
		return "conectado";
	}
}
