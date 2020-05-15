package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.ISerialDao;
import com.servitec.modelo.entidad.Serial;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("SerialServicioImpl")
public class SerialServicioImpl implements IServicio<Serial, Long> {

	@Autowired
	private ISerialDao serialDao;

	@Override
	@Transactional(readOnly = true)
	public List<Serial> findAll() {
		return (List<Serial>) this.serialDao.findAll();
	}

	@Override
	@Transactional
	public void save(Serial t) {
		this.serialDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Serial findById(Long id) {
		return this.serialDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.serialDao.deleteById(id);
	}
}
