package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.ICiudadDao;
import com.servitec.modelo.entidad.Ciudad;
import com.servitec.modelo.servicio.interfaz.ICiudadServicio;

@Service
public class CiudadServicioImpl implements ICiudadServicio {

	@Autowired
	private ICiudadDao ciudadDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> listar() {
		return this.ciudadDao.buscarTodo();
	}

}
