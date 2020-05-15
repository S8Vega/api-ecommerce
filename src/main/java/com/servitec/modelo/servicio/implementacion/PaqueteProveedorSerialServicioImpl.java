package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPaqueteProveedorSerialDao;
import com.servitec.modelo.entidad.PaqueteProveedorSerial;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PaqueteProveedorSerialServicioImpl")
public class PaqueteProveedorSerialServicioImpl implements IServicio<PaqueteProveedorSerial, Long> {

	@Autowired
	private IPaqueteProveedorSerialDao paqueteProveedorSerialDao;

	@Override
	@Transactional(readOnly = true)
	public List<PaqueteProveedorSerial> findAll() {
		return (List<PaqueteProveedorSerial>) this.paqueteProveedorSerialDao.findAll();
	}

	@Override
	@Transactional
	public void save(PaqueteProveedorSerial paqueteProveedorSerial) {
		this.paqueteProveedorSerialDao.save(paqueteProveedorSerial);
	}

	@Override
	@Transactional(readOnly = true)
	public PaqueteProveedorSerial findById(Long id) {
		return this.paqueteProveedorSerialDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.paqueteProveedorSerialDao.deleteById(id);
	}

}
