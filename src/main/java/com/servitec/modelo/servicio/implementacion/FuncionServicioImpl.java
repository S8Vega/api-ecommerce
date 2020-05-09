package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IFuncionDao;
import com.servitec.modelo.entidad.Funcion;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("FuncionServicioImpl")
public class FuncionServicioImpl implements IServicio<Funcion, Long>{
	
	@Autowired
	private IFuncionDao funcionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Funcion> findAll() {
		return (List<Funcion>) this.funcionDao.findAll();
	}

	@Override
	@Transactional
	public void save(Funcion funcion) {
		this.funcionDao.save(funcion);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcion findById(Long id) {
		return this.funcionDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Funcion funcion) {
		this.funcionDao.delete(funcion);
	}

}
