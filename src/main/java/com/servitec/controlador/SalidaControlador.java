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
	public Salida crear(Salida salida) {
		this.salidaServicio.save(salida);
		return salida;
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Salida actualizar(@PathVariable Long id, @RequestBody Salida salida) {
		Salida actual = this.salidaServicio.findById(id);
		actual.setMotivoSalida(salida.getMotivoSalida());
		return actual;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Salida eliminar(@PathVariable Long id) {
		Salida salida = this.salidaServicio.findById(id);
		this.salidaServicio.delete(salida);
		return salida;
	}

}
