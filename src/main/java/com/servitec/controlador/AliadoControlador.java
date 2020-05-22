package com.servitec.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servitec.modelo.entidad.Aliado;
import com.servitec.modelo.servicio.implementacion.AliadoServicioImpl;

@RestController
@RequestMapping("/aliado")
public class AliadoControlador {

	@Autowired
	private AliadoServicioImpl aliadoServicio;

	@RequestMapping
	public List<Aliado> listar() {
		return this.aliadoServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Aliado buscar(@PathVariable Long id) {
		return this.aliadoServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Aliado aliado) {
		this.aliadoServicio.save(aliado);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Aliado aliado) {
		aliado.setAliado_pk(id);
		this.aliadoServicio.save(aliado);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.aliadoServicio.deleteById(id);
	}

	@RequestMapping("/reporte/{id}")
	public Map<String, Object> reporte(@PathVariable Long id) {
		return this.aliadoServicio.reporte(id);
	}

	@RequestMapping("/reporte")
	public List<Object> reporte() {
		return this.aliadoServicio.reporteTodo();
	}

	@RequestMapping("/devolucion/{id}")
	public Map<String, Object> devolucion(@PathVariable Long id) {
		return this.aliadoServicio.devolucion(id);
	}
}
