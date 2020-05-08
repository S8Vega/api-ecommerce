package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IUsuarioDao;
import com.servitec.modelo.entidad.Usuario;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("UsuarioServicioImpl")
public class UsuarioServicioImpl implements IServicio<Usuario, Long> {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) this.usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario Usuario) {
		this.usuarioDao.save(Usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return this.usuarioDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Usuario usuario) {
		this.usuarioDao.delete(usuario);

	}

}
