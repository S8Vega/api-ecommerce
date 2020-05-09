package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servitec.modelo.dao.interfaz.ISalidaDao;
import com.servitec.modelo.entidad.Salida;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("SalidaServicioImpl")
public class SalidaServicioImpl implements IServicio<Salida, Long> {

	@Autowired
	private ISalidaDao salidaDao;

	@Override
	public List<Salida> findAll() {
		// TODO Auto-generated method stub
		return (List<Salida>) this.salidaDao.findAll();
	}

	@Override
	public void save(Salida t) {
		// TODO Auto-generated method stub
		this.salidaDao.save(t);
	}

	@Override
	public Salida findById(Long id) {
		// TODO Auto-generated method stub
		return this.salidaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Salida t) {
		// TODO Auto-generated method stub
		this.salidaDao.delete(t);
	}

}
