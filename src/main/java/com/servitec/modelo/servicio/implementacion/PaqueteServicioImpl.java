package com.servitec.modelo.servicio.implementacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IPaqueteDao;
import com.servitec.modelo.entidad.Paquete;
import com.servitec.modelo.entidad.PaqueteClienteSerial;
import com.servitec.modelo.entidad.PaqueteProveedorSerial;
import com.servitec.modelo.servicio.interfaz.IServicio;

@Service("PaqueteServicioImpl")
public class PaqueteServicioImpl implements IServicio<Paquete, Long> {

	@Autowired
	private IPaqueteDao paqueteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Paquete> findAll() {
		return (List<Paquete>) this.paqueteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Paquete Paquete) {
		this.paqueteDao.save(Paquete);
	}

	@Override
	@Transactional(readOnly = true)
	public Paquete findById(Long id) {
		return this.paqueteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.paqueteDao.deleteById(id);
	}

	@Transactional
	public Map<String, Object> devolucion(Long id) {
		Map<String, Object> objeto = new HashMap<>();
		List<Long> serial = new ArrayList<>();
		Paquete paquete = findById(id);
		if (paquete.getPaqueteCliente() != null) {
			objeto.put("tipo", "cliente");
			for (PaqueteClienteSerial paqueteCS : paquete.getPaqueteCliente().getPaqueteClienteSerial()) {
				if (!paqueteCS.getSerial_fk().getControlCalidad()) {
					serial.add(paqueteCS.getSerial_fk().getSerial_pk());
				}
			}
		}
		if (paquete.getPaqueteProveedor() != null) {
			objeto.put("tipo", "Proveedor");
			for (PaqueteProveedorSerial paquetePS : paquete.getPaqueteProveedor().getPaqueteProveedorSerial()) {
				if (paquetePS.getSerial_fk().getControlCalidad() == false) {
					serial.add(paquetePS.getSerial_fk().getSerial_pk());
				}
			}
		}
		objeto.put("paquete_pk", paquete.getPaquete_pk());
		objeto.put("listaSerial", serial);
		return objeto;
	}
}
