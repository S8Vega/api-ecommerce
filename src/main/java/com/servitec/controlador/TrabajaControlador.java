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

import com.servitec.modelo.entidad.Trabaja;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("trabaja")
public class TrabajaControlador {

	@Autowired
	@Qualifier("TrabajaServicioImpl")
	private IServicio<Trabaja, Long> trabajaServicio;

	@RequestMapping
	public List<Trabaja> listar() {
		return this.trabajaServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Trabaja buscar(@PathVariable Long id) {
		return this.trabajaServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Trabaja trabaja) {
		this.trabajaServicio.save(trabaja);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void atualizar(@PathVariable Long id, @RequestBody Trabaja trabaja) {
		trabaja.setTrabaja_pk(id);
		this.trabajaServicio.save(trabaja);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.trabajaServicio.deleteById(id);
	}

}
