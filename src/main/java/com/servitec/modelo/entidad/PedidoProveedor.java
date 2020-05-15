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
@Table(name = "pedido_proveedor")
public class PedidoProveedor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pedidoProveedor_pk;
	@ManyToOne
	@JoinColumn(name = "aliado_fk")
	@JsonIgnoreProperties(value = { "usuario_fk", "tipoDoc_fk", "documento", "pedidoCliente",
			"pedidoProveedor" }, allowSetters = true)
	private Aliado aliado_fk;
	@OneToMany(mappedBy = "pedidoProveedor_fk", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "pedidoProveedor_fk", "paquete_fk", "paqueteProveedorSerial" }, allowSetters = true)
	private Set<PaqueteProveedor> paqueteProveedor;
	@OneToOne
	@JoinColumn(name = "pedido_fk", unique = true)
	@JsonIgnoreProperties(value = { "fechaCreacion", "fechaEntrega", "codigo", "pedidoCliente",
			"pedidoProveedor" }, allowSetters = true)
	private Pedido pedido_fk;
	private static final long serialVersionUID = 1L;

	public PedidoProveedor() {
	}

	public PedidoProveedor(Aliado aliado_fk, Set<PaqueteProveedor> paqueteProveedor, Pedido pedido_fk) {
		this.aliado_fk = aliado_fk;
		this.paqueteProveedor = paqueteProveedor;
		this.pedido_fk = pedido_fk;
	}

	public Long getPedidoProveedor_pk() {
		return pedidoProveedor_pk;
	}

	public void setPedidoProveedor_pk(Long pedidoProveedor_pk) {
		this.pedidoProveedor_pk = pedidoProveedor_pk;
	}

	public Pedido getPedido_fk() {
		return pedido_fk;
	}

	public void setPedido_fk(Pedido pedido_fk) {
		this.pedido_fk = pedido_fk;
	}

	public Aliado getAliado_fk() {
		return aliado_fk;
	}

	public void setAliado_fk(Aliado aliado_fk) {
		this.aliado_fk = aliado_fk;
	}

	public Set<PaqueteProveedor> getPaqueteProveedor() {
		return paqueteProveedor;
	}

	public void setPaqueteProveedor(Set<PaqueteProveedor> paqueteProveedor) {
		this.paqueteProveedor = paqueteProveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
