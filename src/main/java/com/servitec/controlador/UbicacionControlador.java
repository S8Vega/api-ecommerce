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

import com.servitec.modelo.entidad.Ubicacion;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionControlador {

	@Autowired
	@Qualifier("UbicacionServicioImpl")
	private IServicio<Ubicacion, Long> ubicacionServicio;

	@RequestMapping
	public List<Ubicacion> listar() {
		return this.ubicacionServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Ubicacion buscar(@PathVariable Long id) {
		return this.ubicacionServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Ubicacion ubicacion) {
		this.ubicacionServicio.save(ubicacion);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Ubicacion ubicacion) {
		ubicacion.setUbicacion_pk(id);
		this.ubicacionServicio.save(ubicacion);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.ubicacionServicio.deleteById(id);
	}

}
