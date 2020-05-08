package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPaqueteProveedorDao;
import com.servitec.modelo.entidad.PaqueteCliente;
import com.servitec.modelo.entidad.PaqueteProveedor;
import com.servitec.modelo.servicio.interfaz.IPaqueteClienteServicio;
import com.servitec.modelo.servicio.interfaz.IPaqueteProveedorServicio;

@Service
public class PaqueteProveedorImpl implements IPaqueteProveedorServicio{
	
	@Autowired
	private IPaqueteProveedorDao paqueteProveedorDao;

	@Override
	@Transactional(readOnly = true)
	public List<PaqueteProveedor> findAll(){
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
	public void delete(PaqueteProveedor paqueteProveedor) {
		this.paqueteProveedorDao.delete(paqueteProveedor);
	}
}
