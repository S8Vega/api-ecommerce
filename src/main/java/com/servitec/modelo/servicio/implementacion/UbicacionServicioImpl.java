package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IUbicacionDao;
import com.servitec.modelo.entidad.Ubicacion;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("UbicacionServicioImpl")
public class UbicacionServicioImpl implements IServicio<Ubicacion, Long> {

	@Autowired
	private IUbicacionDao ubicacionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Ubicacion> findAll() {
		return (List<Ubicacion>) this.ubicacionDao.findAll();
	}

	@Override
	@Transactional
	public void save(Ubicacion Ubicacion) {
		this.ubicacionDao.save(Ubicacion);
	}

	@Override
	@Transactional(readOnly = true)
	public Ubicacion findById(Long id) {
		return this.ubicacionDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Ubicacion Ubicacion) {
		this.ubicacionDao.delete(Ubicacion);

	}

}
