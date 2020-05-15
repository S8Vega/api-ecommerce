package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.ITrabajaDao;
import com.servitec.modelo.entidad.Trabaja;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("TrabajaServicioImpl")
public class TrabajaServicioImpl implements IServicio<Trabaja, Long> {

	@Autowired
	private ITrabajaDao trabajaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Trabaja> findAll() {
		return (List<Trabaja>) this.trabajaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Trabaja t) {
		this.trabajaDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Trabaja findById(Long id) {
		return this.trabajaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.trabajaDao.deleteById(id);
	}

}
