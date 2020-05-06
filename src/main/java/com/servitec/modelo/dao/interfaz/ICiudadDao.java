package com.servitec.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.servitec.modelo.entidad.Ciudad;

public interface ICiudadDao extends CrudRepository<Ciudad, Long> {

}
