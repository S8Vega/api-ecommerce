package com.servitec.modelo.dao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.ICiudadDao;
import com.servitec.modelo.entidad.Ciudad;

@Repository("CiudadDaoImpl")
public class CiudadDaoImpl implements ICiudadDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Ciudad> buscarTodo() {
		return em.createQuery("from Ciudad").getResultList();
	}

}
