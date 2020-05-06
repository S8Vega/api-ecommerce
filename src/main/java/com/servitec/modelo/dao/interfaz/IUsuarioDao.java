package com.servitec.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.servitec.modelo.entidad.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
