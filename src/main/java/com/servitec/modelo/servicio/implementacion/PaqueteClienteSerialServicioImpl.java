package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPaqueteClienteSerialDao;
import com.servitec.modelo.entidad.PaqueteClienteSerial;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PaqueteClienteSerialServicioImpl")
public class PaqueteClienteSerialServicioImpl implements IServicio<PaqueteClienteSerial, Long> {

	@Autowired
	private IPaqueteClienteSerialDao paqueteClienteSerialDao;

	@Override
	@Transactional(readOnly = true)
	public List<PaqueteClienteSerial> findAll() {
		return (List<PaqueteClienteSerial>) this.paqueteClienteSerialDao.findAll();
	}

	@Override
	@Transactional
	public void save(PaqueteClienteSerial paqueteClienteSerial) {
		this.paqueteClienteSerialDao.save(paqueteClienteSerial);
	}

	@Override
	@Transactional(readOnly = true)
	public PaqueteClienteSerial findById(Long id) {
		return this.paqueteClienteSerialDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(PaqueteClienteSerial paqueteClienteSerial) {
		this.paqueteClienteSerialDao.delete(paqueteClienteSerial);
	}

}
