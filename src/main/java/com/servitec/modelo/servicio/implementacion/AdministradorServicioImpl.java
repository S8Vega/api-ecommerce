package com.servitec.modelo.servicio.implementacion;

import java.util.List;

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
	@Transactional
	public List<Administrador> findAll() {
		// TODO Auto-generated method stub
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
	public void delete(Administrador t) {
		this.administradorDao.delete(t);
	}

}
