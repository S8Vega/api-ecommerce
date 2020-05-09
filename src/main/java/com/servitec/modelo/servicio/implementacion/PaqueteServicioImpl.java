package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPaqueteDao;
import com.servitec.modelo.entidad.Paquete;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PaqueteServicioImpl")
public class PaqueteServicioImpl implements IServicio<Paquete, Long> {

	@Autowired
	private IPaqueteDao paqueteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Paquete> findAll() {
		return (List<Paquete>) this.paqueteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Paquete Paquete) {
		this.paqueteDao.save(Paquete);
	}

	@Override
	@Transactional(readOnly = true)
	public Paquete findById(Long id) {
		return this.paqueteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Paquete paquete) {
		this.paqueteDao.delete(paquete);
	}
}
