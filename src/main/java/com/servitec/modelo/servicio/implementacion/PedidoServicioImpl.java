package com.servitec.modelo.servicio.implementacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private PaqueteServicioImpl paqueteServicio;

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
	public void controlCalidad(Long id) {
		Pedido pedido = findById(id);
		if (pedido.getPedidoCliente() != null) {
			for (PaqueteCliente pc : pedido.getPedidoCliente().getPaqueteCliente()) {
				paqueteServicio.controlCalidad(pc.getPaquete_fk().getPaquete_pk());
			}
		}
		if (pedido.getPedidoProveedor() != null) {
			for (PaqueteProveedor pp : pedido.getPedidoProveedor().getPaqueteProveedor()) {
				paqueteServicio.controlCalidad(pp.getPaquete_fk().getPaquete_pk());
			}
		}

	}

	@Transactional
	public Map<String, Object> recibido(Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Pedido pedido = findById(id);
		respuesta.put("pedido_pk", pedido.getPedido_pk());
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
		return respuesta;
	}

	@Transactional
	public Map<String, Object> reporte(Long id) {
		Map<String, Object> objeto = new HashMap<>();
		Pedido pedido = findById(id);
		List<Object> listaPaquete = new ArrayList<>();
		objeto.put("pedido_pk", id);
		if (pedido.getPedidoCliente() != null) {
			objeto.put("tipoPedido", "cliente");
			for (PaqueteCliente pc : pedido.getPedidoCliente().getPaqueteCliente()) {
				listaPaquete.add(this.paqueteServicio.reporte(pc.getPaquete_fk().getPaquete_pk()));
			}
		}
		if (pedido.getPedidoProveedor() != null) {
			objeto.put("tipoPedido", "proveedor");
			for (PaqueteProveedor pp : pedido.getPedidoProveedor().getPaqueteProveedor()) {
				listaPaquete.add(this.paqueteServicio.reporte(pp.getPaquete_fk().getPaquete_pk()));
			}
		}
		objeto.put("listaPaquete", listaPaquete);
		return objeto;
	}

	@Transactional
	public Map<String, Object> devolucion(Long id) {
		Map<String, Object> objeto = new HashMap<>();
		List<Object> lista = new ArrayList<>();
		Pedido pedido = findById(id);
		if (pedido.getPedidoCliente() != null) {
			objeto.put("tipo", "cliente");
			for (PaqueteCliente paqueteCliente : pedido.getPedidoCliente().getPaqueteCliente()) {
				lista.add(paqueteServicio.devolucion(paqueteCliente.getPaquete_fk().getPaquete_pk()));
			}
		}
		if (pedido.getPedidoProveedor() != null) {
			objeto.put("tipo", "proveedor");
			for (PaqueteProveedor paqueteProveedor : pedido.getPedidoProveedor().getPaqueteProveedor()) {
				lista.add(paqueteServicio.devolucion(paqueteProveedor.getPaquete_fk().getPaquete_pk()));
			}
		}
		objeto.put("pedido_pk", pedido.getPedido_pk());
		objeto.put("listaPaquete", lista);
		return objeto;
	}

}
