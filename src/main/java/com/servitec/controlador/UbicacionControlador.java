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
import com.servitec.modelo.entidad.Ubicacion;
import com.servitec.modelo.servicio.interfaz.IUbicacionServicio;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionControlador {

	@Autowired
	private IUbicacionServicio ubicacionServicio;

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
	public Ubicacion crear(@RequestBody Ubicacion ubicacion) {
		this.ubicacionServicio.save(ubicacion);
		return ubicacion;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Ubicacion actualizar(@PathVariable Long id, @RequestBody Ubicacion ubicacion) {
		Ubicacion ubicacionActual = this.ubicacionServicio.findById(id);
		ubicacionActual.setCiudad_fk(ubicacion.getCiudad_fk());
		ubicacionActual.setDireccion(ubicacion.getDireccion());
		ubicacionActual.setUsuario(ubicacion.getUsuario());
		this.ubicacionServicio.save(ubicacionActual);
		return ubicacionActual;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Ubicacion eliminar(@PathVariable Long id) {
		Ubicacion ubicacion = this.ubicacionServicio.findById(id);
		this.ubicacionServicio.delete(ubicacion);
		return ubicacion;
	}

}
