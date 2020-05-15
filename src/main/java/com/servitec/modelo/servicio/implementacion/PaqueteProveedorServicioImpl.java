package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPaqueteProveedorDao;
import com.servitec.modelo.entidad.PaqueteProveedor;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PaqueteProveedorServicioImpl")
public class PaqueteProveedorServicioImpl implements IServicio<PaqueteProveedor, Long> {

	@Autowired
	private IPaqueteProveedorDao paqueteProveedorDao;

	@Override
	@Transactional(readOnly = true)
	public List<PaqueteProveedor> findAll() {
		return (List<PaqueteProveedor>) this.paqueteProveedorDao.findAll();
	}

	@Override
	@Transactional
	public void save(PaqueteProveedor paqueteProveedor) {
		this.paqueteProveedorDao.save(paqueteProveedor);
	}

	@Override
	@Transactional(readOnly = true)
	public PaqueteProveedor findById(Long id) {
		return this.paqueteProveedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.paqueteProveedorDao.deleteById(id);
	}
}
