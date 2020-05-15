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

import com.servitec.modelo.entidad.Usuario;
import com.servitec.modelo.servicio.interfaz.IServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	@Qualifier("UsuarioServicioImpl")
	private IServicio<Usuario, Long> usuarioServicio;

	@RequestMapping
	public List<Usuario> listar() {
		return this.usuarioServicio.findAll();
	}

	@RequestMapping("/{id}")
	public Usuario buscar(@PathVariable Long id) {
		return this.usuarioServicio.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Usuario usuario) {
		this.usuarioServicio.save(usuario);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		usuario.setUsuario_pk(id);
		this.usuarioServicio.save(usuario);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		this.usuarioServicio.deleteById(id);
	}

}
