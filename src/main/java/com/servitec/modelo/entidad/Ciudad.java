package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ciudad_pk;
	@Column(length = 80, nullable = false)
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ciudad_fk")
	private List<Ubicacion> ubicacion;
	private static final long serialVersionUID = 1L;

	public Ciudad() {
	}

	public Ciudad(String nombre, List<Ubicacion> ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	public List<Ubicacion> getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(List<Ubicacion> ubicacion) {
		this.ubicacion = ubicacion;
	}

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
