package com.servitec.modelo.servicio.implementacion;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.EmpleadoDao;
import com.servitec.modelo.entidad.Empleado;
import com.servitec.modelo.entidad.Usuario;
import com.servitec.modelo.servicio.interfaz.IEmpleadoServicio;

@Service
public class EmpleadoServicioImpl implements IEmpleadoServicio{

	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	public List<Empleado> findAll() {
		
		return (List<Empleado>) this.empleadoDao.findAll();
	}

	@Override
	public void save(Empleado t) {
		this.empleadoDao.save(t);
	}

	@Override
	public Empleado findById(Long id) {
		
		return this.empleadoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Empleado t) {
		this.empleadoDao.delete(t);
	}
	
	
	
}
