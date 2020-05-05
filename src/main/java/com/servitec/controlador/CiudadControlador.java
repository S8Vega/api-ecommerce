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
import com.servitec.modelo.entidad.Ciudad;
import com.servitec.modelo.servicio.interfaz.ICiudadServicio;

@RestController
@RequestMapping("/api")
public class CiudadControlador {

	@Autowired
	private ICiudadServicio ciudadServicio;

	@RequestMapping("/ciudad")
	public List<Ciudad> listar() {
		return this.ciudadServicio.listar();
	}

	@RequestMapping("/ciudad/{id}")
	public Ciudad buscar(@PathVariable Long id) {
		return this.ciudadServicio.buscarId(id);
	}

	@RequestMapping(value = "/ciudad", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Ciudad crear(@RequestBody Ciudad ciudad) {
		this.ciudadServicio.guardar(ciudad);
		return ciudad;
	}

	@RequestMapping(value = "/ciudad/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Ciudad actualizar(@PathVariable Long id, @RequestBody Ciudad ciudad) {
		Ciudad ciudadActual = this.ciudadServicio.buscarId(id);
		ciudadActual.setNombre(ciudad.getNombre());
		ciudadActual.setUbicacion(ciudad.getUbicacion());
		this.ciudadServicio.guardar(ciudadActual);
		return ciudadActual;
	}

	@RequestMapping(value = "/ciudad/{id}", method = RequestMethod.DELETE)
	public Ciudad eliminar(@PathVariable Long id) {
		Ciudad ciudad = this.ciudadServicio.buscarId(id);
		this.ciudadServicio.eliminar(id);
		return ciudad;
	}

}
