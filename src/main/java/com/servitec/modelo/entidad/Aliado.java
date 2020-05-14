package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "aliado")
public class Aliado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aliado_pk;
	@OneToOne
	@JoinColumn(name = "usuario_fk", unique = true)
	@JsonIgnoreProperties(value = { "nombre", "ubicacion_fk", "telefono", "correo", "aliado", "administrador",
			"empleado" })
	private Usuario usuario_fk;
	@ManyToOne
	@JoinColumn(name = "tipoDoc_fk")
	@JsonIgnoreProperties(value = { "nombre", "aliado" })
	private TipoDoc tipoDoc_fk;
	@Column(length = 20)
	private String documento;
	@OneToMany(mappedBy = "aliado_fk", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "paqueteCliente", "aliado_fk", "pedido_fk" })
	private Set<PedidoCliente> pedidoCliente;
	@OneToMany(mappedBy = "aliado_fk", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "paqueteProveedor", "aliado_fk", "pedido_fk" })
	private Set<PedidoProveedor> pedidoProveedor;
	private static final long serialVersionUID = 1L;

	public Aliado() {
	}

	public Aliado(Usuario usuario_fk, TipoDoc tipoDoc_fk, String documento, Set<PedidoCliente> pedidoCliente,
			Set<PedidoProveedor> pedidoProveedor) {
		this.usuario_fk = usuario_fk;
		this.tipoDoc_fk = tipoDoc_fk;
		this.documento = documento;
		this.pedidoCliente = pedidoCliente;
		this.pedidoProveedor = pedidoProveedor;
	}

	public Long getAliado_pk() {
		return aliado_pk;
	}

	public void setAliado_pk(Long aliado_pk) {
		this.aliado_pk = aliado_pk;
	}

	public Usuario getUsuario_fk() {
		return usuario_fk;
	}

	public void setUsuario_fk(Usuario usuario_fk) {
		this.usuario_fk = usuario_fk;
	}

	public TipoDoc getTipoDoc_fk() {
		return tipoDoc_fk;
	}

	public void setTipoDoc_fk(TipoDoc tipoDoc_fk) {
		this.tipoDoc_fk = tipoDoc_fk;
	}

	public Set<PedidoCliente> getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(Set<PedidoCliente> pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public Set<PedidoProveedor> getPedidoProveedor() {
		return pedidoProveedor;
	}

	public void setPedidoProveedor(Set<PedidoProveedor> pedidoProveedor) {
		this.pedidoProveedor = pedidoProveedor;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
