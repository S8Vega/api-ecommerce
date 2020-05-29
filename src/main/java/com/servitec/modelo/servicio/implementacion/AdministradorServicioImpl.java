package com.servitec.modelo.servicio.implementacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IAdministradorDao;
import com.servitec.modelo.entidad.Administrador;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("AdministradorServicioImpl")
public class AdministradorServicioImpl implements IServicio<Administrador, Long> {

	@Autowired
	private IAdministradorDao administradorDao;

	@Override
	@Transactional(readOnly = true)
	public List<Administrador> findAll() {
		return (List<Administrador>) this.administradorDao.findAll();
	}

	@Override
	@Transactional
	public void save(Administrador t) {
		this.administradorDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Administrador findById(Long id) {
		return this.administradorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.administradorDao.deleteById(id);
	}

	@Transactional
	public Map<String, Object> sesion(String alias, String contrasena) {
		Map<String, Object> respuesta = new HashMap<>();
		List<Administrador> lista = findAll();
		for (Administrador administrador : lista) {
			if (administrador.getAlias().equals(alias) && administrador.getContrasena().equals(contrasena)) {
				respuesta.put("administrador_pk", administrador.getAdministrador_pk());
				break;
			}
		}
		respuesta.put("valor", respuesta.size() == 1);
		return respuesta;
	}
}
