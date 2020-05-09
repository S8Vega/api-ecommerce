package com.servitec.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;


import com.servitec.modelo.entidad.Empleado;


public interface IEmpleadoDao extends CrudRepository<Empleado, Long> {

}
