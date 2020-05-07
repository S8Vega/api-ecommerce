package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "obra")
public class Obra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long obra_pk;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "obra_fk")
	private List<Trabaja> trabaja;
	
	
	public Obra() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Obra(Long obra_pk, String nombre) {
		this.obra_pk = obra_pk;
		this.nombre = nombre;
	}



	public Long getObra_pk() {
		return obra_pk;
	}



	public void setObra_pk(Long obra_pk) {
		this.obra_pk = obra_pk;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<Trabaja> getTrabaja() {
		return trabaja;
	}



	public void setTrabaja(List<Trabaja> trabaja) {
		this.trabaja = trabaja;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
