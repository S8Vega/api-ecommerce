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

import com.servitec.modelo.entidad.Administrador;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/administrador")
public class AdministradorControlador {
   
	@Autowired
	@Qualifier("AdministradorServicioImpl")
	private IServicio<Administrador,Long> administradorServicio;
	
	@RequestMapping
	public List<Administrador> listar(){
		return this.administradorServicio.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Administrador crear(@RequestBody Administrador administrador) {
        this.administradorServicio.save(administrador);
        return administrador;
	}
	@RequestMapping("/{id}")
	public Administrador buscar(@PathVariable Long id) {
		return this.administradorServicio.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Administrador actualizar(@PathVariable Long id, @RequestBody Administrador administrador) {
		Administrador admin = this.administradorServicio.findById(id);
		admin.setAlias(administrador.getAlias());
		admin.setContrasena(administrador.getContrasena());
		this.administradorServicio.save(admin);
	    return admin;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Administrador eliminar(@PathVariable Long id) {
		Administrador administrador = this.administradorServicio.findById(id);
		this.administradorServicio.delete(administrador);
		return administrador;
	}
	
	
	
}
