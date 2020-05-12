package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

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
	@JsonIgnoreProperties(value = { "usuario_fk", "tipoDoc_fk", "documento", "pedidoCliente", "pedidoProveedor" })
	private Aliado aliado_fk;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoProveedor_fk")
	@JsonIgnoreProperties(value = { "pedidoProveedor_fk", "paquete_fk", "paqueteProveedorSerial" })
	private List<PaqueteProveedor> paqueteProveedor;
	@OneToOne
	@JoinColumn(name = "pedido_fk")
	@JsonIgnoreProperties(value = { "fechaCreacion", "fechaEntrega", "codigo", "pedidoCliente", "pedidoProveedor" })
	private Pedido pedido_fk;
	private static final long serialVersionUID = 1L;

	public PedidoProveedor() {
	}

	public PedidoProveedor(Aliado aliado_fk, List<PaqueteProveedor> paqueteProveedor, Pedido pedido_fk) {
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

	public List<PaqueteProveedor> getPaqueteProveedor() {
		return paqueteProveedor;
	}

	public void setPaqueteProveedor(List<PaqueteProveedor> paqueteProveedor) {
		this.paqueteProveedor = paqueteProveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
