package com.servitec.modelo.servicio.implementacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.servitec.modelo.dao.interfaz.IEmpleadoDao;
import com.servitec.modelo.entidad.Empleado;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("EmpleadoServicioImpl")
public class EmpleadoServicioImpl implements IServicio<Empleado, Long> {

	@Autowired
	private IEmpleadoDao empleadoDao;
	@PersistenceContext
	private EntityManager em;

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

	@Transactional
	public ResponseEntity<?> sesion(String alias, String contrasena) {
		Map<String, Object> respuesta = new HashMap<>();
		String q = "FROM Empleado WHERE alias='" + alias + "' and contrasena='" + contrasena + "'";
		List<Empleado> empleados = consulta(q);
		respuesta.put("valor", empleados.size() > 0);
		if (empleados.size() > 0)
			respuesta.put("empleado_pk", empleados.get(0).getEmpleado_pk());
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> consulta(String query) {
		return (List<Empleado>) em.createQuery(query).getResultList();
	}

}
