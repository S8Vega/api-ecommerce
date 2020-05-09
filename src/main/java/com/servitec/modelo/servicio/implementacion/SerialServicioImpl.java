package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servitec.modelo.dao.interfaz.ISerialDao;
import com.servitec.modelo.entidad.Serial;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("SerialServicioImpl")
public class SerialServicioImpl implements IServicio<Serial, Long> {

	@Autowired
	private ISerialDao serialDao;

	@Override
	public List<Serial> findAll() {
		return (List<Serial>) this.serialDao.findAll();
	}

	@Override
	public void save(Serial t) {
		this.serialDao.save(t);
	}

	@Override
	public Serial findById(Long id) {
		return this.serialDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Serial t) {
		this.serialDao.delete(t);
	}
}
