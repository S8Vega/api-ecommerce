package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paquete")
public class Paquete implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paquete_pk;
	@Column(length = 80)
	private String medida;
	@Column(nullable = false)
	private Long cantidadInicial;
	@ManyToOne
	@JoinColumn(name = "producto_fk")
	@JsonIgnoreProperties("paquete")
	private Producto producto_fk;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "paquete_fk")
	private PaqueteCliente paqueteCliente;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "paquete_fk")
	private PaqueteProveedor paqueteProveedor;
	private static final long serialVersionUID = 1L;

	public Paquete() {
	}

	public Paquete(String medida, Long cantidadInicial, Producto producto_fk, PaqueteCliente paqueteCliente,
			PaqueteProveedor paqueteProveedor) {
		this.medida = medida;
		this.cantidadInicial = cantidadInicial;
		this.producto_fk = producto_fk;
		this.paqueteCliente = paqueteCliente;
		this.paqueteProveedor = paqueteProveedor;
	}

	public Long getPaquete_pk() {
		return paquete_pk;
	}

	public void setPaquete_pk(Long paquete_pk) {
		this.paquete_pk = paquete_pk;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public Long getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(Long cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public Producto getProducto_fk() {
		return producto_fk;
	}

	public void setProducto_fk(Producto producto_fk) {
		this.producto_fk = producto_fk;
	}

	public PaqueteCliente getPaqueteCliente() {
		return paqueteCliente;
	}

	public void setPaqueteCliente(PaqueteCliente paqueteCliente) {
		this.paqueteCliente = paqueteCliente;
	}

	public PaqueteProveedor getPaqueteProveedor() {
		return paqueteProveedor;
	}

	public void setPaqueteProveedor(PaqueteProveedor paqueteProveedor) {
		this.paqueteProveedor = paqueteProveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
