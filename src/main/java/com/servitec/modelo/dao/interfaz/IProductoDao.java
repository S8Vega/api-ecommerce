package com.servitec.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.servitec.modelo.entidad.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

}
