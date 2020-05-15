package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPaqueteClienteDao;
import com.servitec.modelo.entidad.PaqueteCliente;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PaqueteClienteServicioImpl")
public class PaqueteClienteServicioImpl implements IServicio<PaqueteCliente, Long> {

	@Autowired
	private IPaqueteClienteDao paqueteClienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<PaqueteCliente> findAll() {
		return (List<PaqueteCliente>) this.paqueteClienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(PaqueteCliente paqueteCliente) {
		this.paqueteClienteDao.save(paqueteCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public PaqueteCliente findById(Long id) {
		return this.paqueteClienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.paqueteClienteDao.deleteById(id);
	}

}
