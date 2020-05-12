package com.servitec.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servitec.modelo.entidad.Cargo;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/cargo")
public class CargoControlador {

	@Autowired
	@Qualifier("CargoServicioImpl")
	private IServicio<Cargo, Long> cargoServicio;

	@RequestMapping
	public List<Cargo> listar() {
		return this.cargoServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cargo crear(@RequestBody Cargo cargo) {
		this.cargoServicio.save(cargo);
		return cargo;
	}

	@RequestMapping("/{id}")
	public Cargo buscar(@PathVariable Long id) {
		return this.cargoServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cargo actualizar(@PathVariable Long id, @RequestBody Cargo cargo) {
		Cargo cargoActual = this.cargoServicio.findById(id);
		cargoActual.setEmpleado(cargo.getEmpleado());
		cargoActual.setNombre(cargo.getNombre());
		this.cargoServicio.save(cargoActual);
		return cargoActual;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Transactional
	public Cargo eliminar(@PathVariable Long id) {
		Cargo cargo = this.cargoServicio.findById(id);
		this.cargoServicio.delete(cargo);
		return cargo;
	}

}
