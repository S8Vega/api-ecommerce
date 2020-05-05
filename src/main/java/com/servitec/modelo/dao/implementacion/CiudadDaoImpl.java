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
	public List<Ciudad> listar() {
		return em.createQuery("from Ciudad").getResultList();
	}

	@Override
	@Transactional
	public void guardar(Ciudad ciudad) {
		if (ciudad.getCiudad_pk() != null)
			em.merge(ciudad);
		else
			em.persist(ciudad);

	}

	@Override
	@Transactional(readOnly = true)
	public Ciudad buscarId(Long id) {
		return em.find(Ciudad.class, id);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		em.remove(buscarId(id));

	}

}
