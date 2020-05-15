package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPedidoClienteDao;
import com.servitec.modelo.entidad.PedidoCliente;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PedidoClienteServicioImpl")
public class PedidoClienteServicioImpl implements IServicio<PedidoCliente, Long> {

	@Autowired
	private IPedidoClienteDao pedDao;

	@Override
	@Transactional(readOnly = true)
	public List<PedidoCliente> findAll() {
		return (List<PedidoCliente>) this.pedDao.findAll();
	}

	@Override
	@Transactional
	public void save(PedidoCliente pedidoCliente) {
		this.pedDao.save(pedidoCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public PedidoCliente findById(Long id) {
		return this.pedDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.pedDao.deleteById(id);
	}

}
