package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPrestamoDao;
import com.servitec.modelo.entidad.Prestamo;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PrestamoServicioImpl")
public class PrestamoServicioImpl implements IServicio<Prestamo, Long> {

	@Autowired
	private IPrestamoDao prestamoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> findAll() {
		// TODO Auto-generated method stub
		return (List<Prestamo>) this.prestamoDao.findAll();
	}

	@Override
	public void save(Prestamo t) {
		// TODO Auto-generated method stub
		this.prestamoDao.save(t);
	}

	@Override
	public Prestamo findById(Long id) {
		// TODO Auto-generated method stub
		return this.prestamoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Prestamo t) {
		// TODO Auto-generated method stub
		this.prestamoDao.delete(t);
	}
}
