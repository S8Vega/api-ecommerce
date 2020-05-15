package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IObraDao;
import com.servitec.modelo.entidad.Obra;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("ObraServicioImpl")
public class ObraServicioImpl implements IServicio<Obra, Long> {

	@Autowired
	private IObraDao obraDao;

	@Override
	@Transactional(readOnly = true)
	public List<Obra> findAll() {
		return (List<Obra>) this.obraDao.findAll();
	}

	@Override
	@Transactional
	public void save(Obra t) {
		this.obraDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Obra findById(Long id) {
		return this.obraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.obraDao.deleteById(id);
	}

}
