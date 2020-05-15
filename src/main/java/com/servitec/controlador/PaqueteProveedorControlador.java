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

import com.servitec.modelo.entidad.PaqueteProveedor;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/paqueteProveedor")
public class PaqueteProveedorControlador {

	@Autowired
	@Qualifier("PaqueteProveedorServicioImpl")
	private IServicio<PaqueteProveedor, Long> paqueteProveedorServico;

	@RequestMapping
	public List<PaqueteProveedor> listar() {
		return this.paqueteProveedorServico.findAll();
	}

	@RequestMapping("/{id}")
	public PaqueteProveedor buscar(@PathVariable Long id) {
		return this.paqueteProveedorServico.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody PaqueteProveedor paqueteProveedor) {
		this.paqueteProveedorServico.save(paqueteProveedor);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody PaqueteProveedor paqueteProveedor) {
		paqueteProveedor.setPaqueteProveedor_pk(id);
		this.paqueteProveedorServico.save(paqueteProveedor);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.paqueteProveedorServico.deleteById(id);
	}

}
