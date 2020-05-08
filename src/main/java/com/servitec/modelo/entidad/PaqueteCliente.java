package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="paqueteCliente")
public class PaqueteCliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long paqueteCliente_pk;
	
	@ManyToOne
	@JoinColumn(name="pedidoCliente_fk")
	private PedidoCliente pedidoCliente_fk;
	
	@OneToOne
	@JoinColumn(name = "paqueteCliente_fk")
	private Paquete paqueteCliente_fk;
	
	public PaqueteCliente() { 
	}

	public PaqueteCliente(Long paqueteCliente_pk, Long pedidoCliente, Paquete paquete_fk) {
		this.paqueteCliente_pk = paqueteCliente_pk;
		this.pedidoCliente_fk = pedidoCliente_fk;
		this.paqueteCliente_fk = paquete_fk;
	}

	public Long getPaqueteCliente_pk() {
		return paqueteCliente_pk;
	}

	public PedidoCliente getPedidoCliente_fk() {
		return pedidoCliente_fk;
	}

	public void setPedidoCliente_fk(PedidoCliente pedidoCliente_fk) {
		this.pedidoCliente_fk = pedidoCliente_fk;
	}

	public void setPaqueteCliente_pk(Long paqueteCliente_pk) {
		this.paqueteCliente_pk = paqueteCliente_pk;
	}

	public PedidoCliente getPedidoCliente() {
		return pedidoCliente_fk;
	}

	public void setPedidoCliente(PedidoCliente pedidoCliente) {
		this.pedidoCliente_fk = pedidoCliente_fk;
	}

	public Paquete getPaquete_fk() {
		return paqueteCliente_fk;
	}

	public void setPaquete_fk(Paquete paquete_fk) {
		this.paqueteCliente_fk = paquete_fk;
	}

	
	
	public Paquete getPaqueteCliente_fk() {
		return paqueteCliente_fk;
	}

	public void setPaqueteCliente_fk(Paquete paqueteCliente_fk) {
		this.paqueteCliente_fk = paqueteCliente_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
