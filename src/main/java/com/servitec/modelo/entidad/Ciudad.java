package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ciudad_pk;
	@Column(length = 80, nullable = false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public Long getCiudad_pk() {
		return ciudad_pk;
	}

	public void setCiudad_pk(Long ciudad_pk) {
		this.ciudad_pk = ciudad_pk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
