package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="paquete")
public class Paquete implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paquete_pk;
	@Column(length = 10)
	private String medida;
	@Column(nullable = false)
	private long cantidadInicial;
	@Column(nullable = false)
	private long producto_fk;
	
	public Paquete() {
		
	}

	public Paquete(int paquete_pk, String medida, long cantidadInicial, long producto_fk) {
		super();
		this.paquete_pk = paquete_pk;
		this.medida = medida;
		this.cantidadInicial = cantidadInicial;
		this.producto_fk = producto_fk;
	}

	public int getPaquete_pk() {
		return paquete_pk;
	}

	public void setPaquete_pk(int paquete_pk) {
		this.paquete_pk = paquete_pk;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public long getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(long cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public long getProducto_fk() {
		return producto_fk;
	}

	public void setProducto_fk(long producto_fk) {
		this.producto_fk = producto_fk;
	}
	
	
}
