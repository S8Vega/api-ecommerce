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

import com.servitec.modelo.entidad.Obra;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("obra")
public class ObraControlador {
	@Autowired
	@Qualifier("ObraServicioImpl")
	private IServicio<Obra, Long> obraServicio;

	@RequestMapping
	public List<Obra> listar() {
		return this.obraServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Obra buscar(@PathVariable Long id) {
		return this.obraServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Obra crear(@RequestBody Obra obra) {
		this.obraServicio.save(obra);
		return obra;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Obra actualizar(@PathVariable Long id, @RequestBody Obra obra) {
		Obra actual = this.obraServicio.findById(id);
		actual.setNombre(obra.getNombre());
		return actual;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Obra eliminar(@PathVariable Long id) {
		Obra obra = this.obraServicio.findById(id);
		this.obraServicio.delete(obra);
		return obra;
	}
}
