package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPedidoProveedorDao;
import com.servitec.modelo.entidad.PedidoProveedor;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PedidoProveedorServicioImpl")
public class PedidoProveedorServicioImpl implements IServicio<PedidoProveedor, Long> {

	@Autowired
	private IPedidoProveedorDao pedDao;

	@Override
	@Transactional(readOnly = true)
	public List<PedidoProveedor> findAll() {
		return (List<PedidoProveedor>) this.pedDao.findAll();
	}

	@Override
	@Transactional
	public void save(PedidoProveedor pedidoProveedor) {
		this.pedDao.save(pedidoProveedor);
	}

	@Override
	@Transactional(readOnly = true)
	public PedidoProveedor findById(Long id) {
		return this.pedDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.pedDao.deleteById(id);
	}
}
