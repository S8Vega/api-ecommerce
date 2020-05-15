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

import com.servitec.modelo.entidad.Salida;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("salida")
public class SalidaControlador {

	@Autowired
	@Qualifier("SalidaServicioImpl")
	private IServicio<Salida, Long> salidaServicio;

	@RequestMapping
	public List<Salida> listar() {
		return this.salidaServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Salida buscar(@PathVariable Long id) {
		return this.salidaServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(Salida salida) {
		this.salidaServicio.save(salida);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Salida salida) {
		salida.setSalida_pk(id);
		this.salidaServicio.save(salida);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.salidaServicio.deleteById(id);
	}

}
