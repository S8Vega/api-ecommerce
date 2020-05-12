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
@Table(name = "pedido_cliente")
public class PedidoCliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pedidoCliente_pk;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoCliente_fk")
	@JsonIgnoreProperties(value = { "pedidoCliente_fk", "paquete_fk", "paqueteClienteSerial" })
	private List<PaqueteCliente> paqueteCliente;
	@ManyToOne
	@JoinColumn(name = "aliado_fk")
	@JsonIgnoreProperties(value = { "usuario_fk", "tipoDoc_fk", "documento", "pedidoCliente", "pedidoProveedor" })
	private Aliado aliado_fk;
	@OneToOne
	@JoinColumn(name = "pedido_fk")
	@JsonIgnoreProperties(value = { "fechaCreacion", "fechaEntrega", "codigo", "pedidoCliente", "pedidoProveedor" })
	private Pedido pedido_fk;
	private static final long serialVersionUID = 1L;

	public PedidoCliente() {
	}

	public PedidoCliente(List<PaqueteCliente> paqueteClientes, Aliado aliado_fk, Pedido pedido_fk,
			List<PaqueteCliente> paqueteCliente) {
		this.paqueteCliente = paqueteCliente;
		this.aliado_fk = aliado_fk;
		this.pedido_fk = pedido_fk;
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

	public Long getPedidoCliente_pk() {
		return pedidoCliente_pk;
	}

	public List<PaqueteCliente> getPaqueteCliente() {
		return paqueteCliente;
	}

	public void setPaqueteCliente(List<PaqueteCliente> paqueteCliente) {
		this.paqueteCliente = paqueteCliente;
	}

	public void setPedidoCliente_pk(Long pedidoCliente_pk) {
		this.pedidoCliente_pk = pedidoCliente_pk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
