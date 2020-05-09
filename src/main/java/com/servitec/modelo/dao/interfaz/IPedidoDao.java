package com.servitec.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.servitec.modelo.entidad.Pedido;

public interface IPedidoDao extends CrudRepository<Pedido, Long> {

}
