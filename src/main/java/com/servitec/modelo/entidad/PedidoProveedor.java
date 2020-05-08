package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pedidoProveedor")
public class PedidoProveedor implements Serializable {
	
	@Id
	private Long pedidoProveedor;
	@Column
	private Long proveedor_fk;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PedidoProveedor() {
		}

	public PedidoProveedor(Long pedidoProveedor, Long proveedor_fk) {
		this.pedidoProveedor = pedidoProveedor;
		this.proveedor_fk = proveedor_fk;
	}

	public Long getPedidoProveedor() {
		return pedidoProveedor;
	}

	public void setPedidoProveedor(Long pedidoProveedor) {
		this.pedidoProveedor = pedidoProveedor;
	}

	public Long getProveedor_fk() {
		return proveedor_fk;
	}

	public void setProveedor_fk(Long proveedor_fk) {
		this.proveedor_fk = proveedor_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
