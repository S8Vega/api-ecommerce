package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.ISalidaDao;
import com.servitec.modelo.entidad.Salida;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("SalidaServicioImpl")
public class SalidaServicioImpl implements IServicio<Salida, Long> {

	@Autowired
	private ISalidaDao salidaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Salida> findAll() {
		return (List<Salida>) this.salidaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Salida t) {
		this.salidaDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Salida findById(Long id) {
		return this.salidaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Salida t) {
		this.salidaDao.delete(t);
	}

}
