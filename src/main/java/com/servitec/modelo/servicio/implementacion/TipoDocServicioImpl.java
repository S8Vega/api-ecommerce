package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.ITipoDocDao;
import com.servitec.modelo.entidad.TipoDoc;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("TipoDocServicioImpl")
public class TipoDocServicioImpl implements IServicio<TipoDoc, Long> {

	@Autowired
	private ITipoDocDao tipoDocDao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoDoc> findAll() {
		return (List<TipoDoc>) this.tipoDocDao.findAll();
	}

	@Override
	@Transactional
	public void save(TipoDoc TipoDoc) {
		this.tipoDocDao.save(TipoDoc);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoDoc findById(Long id) {
		return this.tipoDocDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(TipoDoc tipoDoc) {
		this.tipoDocDao.delete(tipoDoc);

	}

}
