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
import com.servitec.modelo.entidad.Usuario;
import com.servitec.modelo.servicio.interfaz.IUsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private IUsuarioServicio usuarioServicio;

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
	public Usuario crear(@RequestBody Usuario usuario) {
		this.usuarioServicio.save(usuario);
		return usuario;
	}

	@RequestMapping(value = "/{id}", method =
			RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Usuario actualizar(@PathVariable Long id, 
			@RequestBody Usuario usuario) {
		Usuario usuarioActual = 
				this.usuarioServicio.findById(id);
		usuarioActual.setCorreo(usuario.getCorreo());
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setTelefono(usuario.getTelefono());
		usuarioActual.setUbicacion_fk(usuario.
				getUbicacion_fk());
		this.usuarioServicio.save(usuarioActual);
		return usuarioActual;
	}

	@RequestMapping(value = "/{id}", method = 
			RequestMethod.DELETE)
	public Usuario eliminar(@PathVariable Long id) {
		Usuario usuario = this.usuarioServicio.
				findById(id);
		this.usuarioServicio.delete(usuario);
		return usuario;
	}

}
