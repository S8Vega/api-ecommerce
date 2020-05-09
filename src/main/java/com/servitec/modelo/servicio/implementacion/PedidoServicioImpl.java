package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPedidoDao;
import com.servitec.modelo.entidad.Pedido;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PedidoServicioImpl")
public class PedidoServicioImpl implements IServicio<Pedido, Long> {

	@Autowired
	private IPedidoDao pedidoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> findAll() {
		return (List<Pedido>) this.pedidoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Pedido Pedido) {
		this.pedidoDao.save(Pedido);
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido findById(Long id) {
		return this.pedidoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Pedido pedido) {
		this.pedidoDao.delete(pedido);

	}

}
