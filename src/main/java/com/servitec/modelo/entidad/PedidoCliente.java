package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "pedidoCliente")
public class PedidoCliente implements Serializable {

	@Id
	private Long pedidoCliente_pk;
	@Column
	private Long cliente_fk;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PedidoCliente() {
	}
	public PedidoCliente(Long pedidoCliente_pk, Long cliente_fk) {
		this.pedidoCliente_pk = pedidoCliente_pk;
		this.cliente_fk = cliente_fk;
	}
	public Long getPedidoCliente_pk() {
		return pedidoCliente_pk;
	}
	public void setPedidoCliente_pk(Long pedidoCliente_pk) {
		this.pedidoCliente_pk = pedidoCliente_pk;
	}
	public Long getCliente_fk() {
		return cliente_fk;
	}
	public void setCliente_fk(Long cliente_fk) {
		this.cliente_fk = cliente_fk;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
}
