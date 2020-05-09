package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.ICargoDao;
import com.servitec.modelo.entidad.Cargo;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("CargoServicioImpl")
public class CargoServicioImpl implements IServicio<Cargo, Long> {

	@Autowired
	private ICargoDao cargoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> findAll() {
		return (List<Cargo>) this.cargoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cargo Cargo) {
		this.cargoDao.save(Cargo);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo findById(Long id) {
		return this.cargoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Cargo cargo) {
		this.cargoDao.delete(cargo);

	}

}
