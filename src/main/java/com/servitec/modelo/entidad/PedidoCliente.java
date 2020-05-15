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
@Table(name = "pedido_cliente")
public class PedidoCliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pedidoCliente_pk;
	@OneToMany(mappedBy = "pedidoCliente_fk", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "pedidoCliente_fk", "paquete_fk", "paqueteClienteSerial" }, allowSetters = true)
	private Set<PaqueteCliente> paqueteCliente;
	@ManyToOne
	@JoinColumn(name = "aliado_fk")
	@JsonIgnoreProperties(value = { "usuario_fk", "tipoDoc_fk", "documento", "pedidoCliente",
			"pedidoProveedor" }, allowSetters = true)
	private Aliado aliado_fk;
	@OneToOne
	@JoinColumn(name = "pedido_fk", unique = true)
	@JsonIgnoreProperties(value = { "fechaCreacion", "fechaEntrega", "codigo", "pedidoCliente",
			"pedidoProveedor" }, allowSetters = true)
	private Pedido pedido_fk;
	private static final long serialVersionUID = 1L;

	public PedidoCliente() {
	}

	public PedidoCliente(Set<PaqueteCliente> paqueteCliente, Aliado aliado_fk, Pedido pedido_fk) {
		this.paqueteCliente = paqueteCliente;
		this.aliado_fk = aliado_fk;
		this.pedido_fk = pedido_fk;
	}

	public Long getPedidoCliente_pk() {
		return pedidoCliente_pk;
	}

	public void setPedidoCliente_pk(Long pedidoCliente_pk) {
		this.pedidoCliente_pk = pedidoCliente_pk;
	}

	public Set<PaqueteCliente> getPaqueteCliente() {
		return paqueteCliente;
	}

	public void setPaqueteCliente(Set<PaqueteCliente> paqueteCliente) {
		this.paqueteCliente = paqueteCliente;
	}

	public Aliado getAliado_fk() {
		return aliado_fk;
	}

	public void setAliado_fk(Aliado aliado_fk) {
		this.aliado_fk = aliado_fk;
	}

	public Pedido getPedido_fk() {
		return pedido_fk;
	}

	public void setPedido_fk(Pedido pedido_fk) {
		this.pedido_fk = pedido_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
