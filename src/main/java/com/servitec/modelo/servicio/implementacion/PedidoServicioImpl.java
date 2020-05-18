package com.servitec.modelo.servicio.implementacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPedidoDao;
import com.servitec.modelo.entidad.PaqueteCliente;
import com.servitec.modelo.entidad.PaqueteProveedor;
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
	public void save(Pedido pedido) {
		this.pedidoDao.save(pedido);
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido findById(Long id) {
		return this.pedidoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.pedidoDao.deleteById(id);
	}

	@Transactional
	public ResponseEntity<?> recibido(Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Pedido pedido = this.pedidoDao.findById(id).orElse(null);
		if (pedido.getPedidoProveedor() != null) {
			respuesta.put("pedidoTipo", "Proveedor");
			Set<PaqueteProveedor> paquete = pedido.getPedidoProveedor().getPaqueteProveedor();
			respuesta.put("cantidadPaquetes", paquete.size());
			Long cantidadInicial = (long) 0, cantidadActual = (long) 0;
			Map<Long, Long> falta = new HashMap<>();
			for (PaqueteProveedor p : paquete) {
				cantidadInicial += p.getPaquete_fk().getCantidadInicial();
				cantidadActual += p.getPaqueteProveedorSerial().size();
				if (p.getPaqueteProveedorSerial().size() < p.getPaquete_fk().getCantidadInicial()) {
					falta.put(p.getPaquete_fk().getProducto_fk().getProducto_pk(),
							p.getPaquete_fk().getCantidadInicial() - p.getPaqueteProveedorSerial().size());
				}
			}
			respuesta.put("cantidadInicial", cantidadInicial);
			respuesta.put("cantidadActual", cantidadActual);
			respuesta.put("porductosPendientes", falta);
			respuesta.put("recibido", cantidadInicial == cantidadActual);
		}
		if (pedido.getPedidoCliente() != null) {
			respuesta.put("pedidoTipo", "Cliente");
			Set<PaqueteCliente> paquete = pedido.getPedidoCliente().getPaqueteCliente();
			respuesta.put("cantidadPaquetes", paquete.size());
			Long cantidadInicial = (long) 0, cantidadActual = (long) 0;
			Map<Long, Long> falta = new HashMap<>();
			for (PaqueteCliente p : paquete) {
				cantidadInicial += p.getPaquete_fk().getCantidadInicial();
				cantidadActual += p.getPaqueteClienteSerial().size();
				if (p.getPaqueteClienteSerial().size() < p.getPaquete_fk().getCantidadInicial()) {
					falta.put(p.getPaquete_fk().getProducto_fk().getProducto_pk(),
							p.getPaquete_fk().getCantidadInicial() - p.getPaqueteClienteSerial().size());
				}
			}
			respuesta.put("cantidadInicial", cantidadInicial);
			respuesta.put("cantidadActual", cantidadActual);
			respuesta.put("porductosPendientes", falta);
			respuesta.put("recibido", cantidadInicial == cantidadActual);
		}
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}
}
