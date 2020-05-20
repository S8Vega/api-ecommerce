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

import com.servitec.modelo.entidad.Paquete;
import com.servitec.modelo.servicio.implementacion.PaqueteServicioImpl;

@RestController
@RequestMapping("/paquete")
public class PaqueteControlador {

	@Autowired
	private PaqueteServicioImpl paqueteServicio;

	@RequestMapping
	public List<Paquete> listar() {
		return this.paqueteServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Paquete buscar(@PathVariable long id) {
		return this.paqueteServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Paquete paquete) {
		this.paqueteServicio.save(paquete);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Paquete paquete) {
		paquete.setPaquete_pk(id);
		this.paqueteServicio.save(paquete);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.paqueteServicio.deleteById(id);
	}

	@RequestMapping("/devolucion/{id}")
	public Map<String, Object> devolucion(@PathVariable Long id) {
		return this.paqueteServicio.devolucion(id);
	}

}
