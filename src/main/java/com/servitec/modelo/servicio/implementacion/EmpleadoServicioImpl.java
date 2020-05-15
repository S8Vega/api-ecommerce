package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IEmpleadoDao;
import com.servitec.modelo.entidad.Empleado;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("EmpleadoServicioImpl")
public class EmpleadoServicioImpl implements IServicio<Empleado, Long> {

	@Autowired
	private IEmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return (List<Empleado>) this.empleadoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Empleado t) {
		this.empleadoDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {
		return this.empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.empleadoDao.deleteById(id);
	}

}
