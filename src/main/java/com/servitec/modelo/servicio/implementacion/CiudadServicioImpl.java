package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.ICiudadDao;
import com.servitec.modelo.entidad.Ciudad;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("CiudadServicioImpl")
public class CiudadServicioImpl implements IServicio<Ciudad, Long> {

	@Autowired
	private ICiudadDao ciudadDao;

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findAll() {
		return (List<Ciudad>) this.ciudadDao.findAll();
	}

	@Override
	@Transactional
	public void save(Ciudad Ciudad) {
		this.ciudadDao.save(Ciudad);
	}

	@Override
	@Transactional(readOnly = true)
	public Ciudad findById(Long id) {
		return this.ciudadDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Ciudad ciudad) {
		this.ciudadDao.delete(ciudad);

	}

}
