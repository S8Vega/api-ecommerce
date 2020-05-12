package com.servitec.modelo.dao.implementacion;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.servitec.modelo.dao.interfaz.IAdministradorDao;
import com.servitec.modelo.entidad.Administrador;

//@Repository("AdministradorDaoImpl")
public class AdministradorDaoImpl implements IAdministradorDao {

	@Autowired
	private IAdministradorDao administradorDao;
	@PersistenceContext
	private EntityManager em;

	@Override
	public <S extends Administrador> S save(S entity) {
		return administradorDao.save(entity);
	}

	@Override
	public <S extends Administrador> Iterable<S> saveAll(Iterable<S> entities) {
		return administradorDao.saveAll(entities);
	}

	@Override
	public Optional<Administrador> findById(Long id) {
		return administradorDao.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return administradorDao.existsById(id);
	}

	@Override
	public Iterable<Administrador> findAll() {
		return administradorDao.findAll();
	}

	@Override
	public Iterable<Administrador> findAllById(Iterable<Long> ids) {
		return administradorDao.findAllById(ids);
	}

	@Override
	public long count() {
		return administradorDao.count();
	}

	@Override
	public void deleteById(Long id) {
		administradorDao.deleteById(id);
	}

	@Override
	public void delete(Administrador entity) {
		administradorDao.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Administrador> entities) {
		administradorDao.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		administradorDao.deleteAll();
	}
}
