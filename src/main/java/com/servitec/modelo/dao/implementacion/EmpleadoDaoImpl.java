package com.servitec.modelo.dao.implementacion;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.CrudRepository;

import com.servitec.modelo.dao.interfaz.IEmpleadoDao;
import com.servitec.modelo.entidad.Empleado;

//@Repository
public class EmpleadoDaoImpl implements IEmpleadoDao {

	private CrudRepository<Empleado, Long> crud;
	@PersistenceContext
	private EntityManager em;

	public Long inicioSesion(String alias, String contrasena) {
		Empleado empleado = (Empleado) em
				.createQuery("from empleado where alias=" + alias + " and contrasena = " + contrasena).getResultList();
		return empleado.getEmpleado_pk();
	}

	@Override
	public <S extends Empleado> S save(S entity) {
		return crud.save(entity);
	}

	@Override
	public <S extends Empleado> Iterable<S> saveAll(Iterable<S> entities) {
		return crud.saveAll(entities);
	}

	@Override
	public Optional<Empleado> findById(Long id) {
		return crud.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return crud.existsById(id);
	}

	@Override
	public Iterable<Empleado> findAll() {
		System.out.println("f");
		return crud.findAll();
	}

	@Override
	public Iterable<Empleado> findAllById(Iterable<Long> ids) {
		return crud.findAllById(ids);
	}

	@Override
	public long count() {
		return crud.count();
	}

	@Override
	public void deleteById(Long id) {
		crud.deleteById(id);
	}

	@Override
	public void delete(Empleado entity) {
		crud.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Empleado> entities) {
		crud.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		crud.deleteAll();
	}

}
