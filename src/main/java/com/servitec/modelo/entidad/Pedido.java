package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pedido_pk;
	@Column(name = "fecha_creacion", nullable = false)
	private LocalDate fechaCreacion;
	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;
	@Column(length = 15)
	private String codigo;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido_fk")
	@JsonIgnoreProperties(value = { "paqueteCliente", "aliado_fk", "pedido_fk" })
	private PedidoCliente pedidoCliente;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido_fk")
	@JsonIgnoreProperties(value = { "paqueteProveedor", "aliado_fk", "pedido_fk" })
	private PedidoProveedor pedidoProveedor;
	private static final long serialVersionUID = 1L;

	public Pedido() {
	}

	public Pedido(LocalDate fechaCreacion, LocalDate fechaEntrega, String codigo, PedidoCliente pedidoCliente,
			PedidoProveedor pedidoProveedor) {
		this.fechaCreacion = fechaCreacion;
		this.fechaEntrega = fechaEntrega;
		this.codigo = codigo;
		this.pedidoCliente = pedidoCliente;
		this.pedidoProveedor = pedidoProveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getPedido_pk() {
		return pedido_pk;
	}

	public void setPedido_pk(Long pedido_pk) {
		this.pedido_pk = pedido_pk;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public PedidoCliente getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(PedidoCliente pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public PedidoProveedor getPedidoProveedor() {
		return pedidoProveedor;
	}

	public void setPedidoProveedor(PedidoProveedor pedidoProveedor) {
		this.pedidoProveedor = pedidoProveedor;
	}

}
