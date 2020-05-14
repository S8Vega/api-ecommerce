package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paquete_proveedor")
public class PaqueteProveedor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paqueteProveedor_pk;
	@ManyToOne
	@JoinColumn(name = "pedidoProveedor_fk")
	@JsonIgnoreProperties(value = { "paqueteProveedor", "aliado_fk", "pedido_fk" })
	private PedidoProveedor pedidoProveedor_fk;
	@OneToOne
	@JoinColumn(name = "paquete_fk", unique = true)
	@JsonIgnoreProperties(value = { "medida", "cantidadInicial", "producto_fk", "paqueteProveedor", "paqueteCliente" })
	private Paquete paquete_fk;
	@OneToMany(mappedBy = "paqueteProveedor_fk", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "serial_fk", "paqueteProveedor_fk" })
	private Set<PaqueteProveedorSerial> paqueteProveedorSerial;
	private static final long serialVersionUID = 1L;

	public PaqueteProveedor() {
	}

	public PaqueteProveedor(PedidoProveedor pedidoProveedor_fk, Paquete paquete_fk,
			Set<PaqueteProveedorSerial> paqueteProveedorSerial) {
		this.pedidoProveedor_fk = pedidoProveedor_fk;
		this.paquete_fk = paquete_fk;
		this.paqueteProveedorSerial = paqueteProveedorSerial;
	}

	public Long getPaqueteProveedor_pk() {
		return paqueteProveedor_pk;
	}

	public void setPaqueteProveedor_pk(Long paqueteProveedor_pk) {
		this.paqueteProveedor_pk = paqueteProveedor_pk;
	}

	public PedidoProveedor getPedidoProveedor_fk() {
		return pedidoProveedor_fk;
	}

	public void setPedidoProveedor_fk(PedidoProveedor pedidoProveedor_fk) {
		this.pedidoProveedor_fk = pedidoProveedor_fk;
	}

	public Paquete getPaquete_fk() {
		return paquete_fk;
	}

	public void setPaquete_fk(Paquete paquete_fk) {
		this.paquete_fk = paquete_fk;
	}

	public Set<PaqueteProveedorSerial> getPaqueteProveedorSerial() {
		return paqueteProveedorSerial;
	}

	public void setPaqueteProveedorSerial(Set<PaqueteProveedorSerial> paqueteProveedorSerial) {
		this.paqueteProveedorSerial = paqueteProveedorSerial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
