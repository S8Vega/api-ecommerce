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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ubicacion")
public class Ubicacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ubicacion_pk;
	@ManyToOne
	@JoinColumn(name = "ciudad_fk")
	@JsonIgnoreProperties("ubicacion")
	private Ciudad ciudad_fk;
	@Column(length = 250, nullable = false)
	private String direccion;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ubicacion_fk")
	private List<Usuario> usuario;
	private static final long serialVersionUID = 1L;

	public Ubicacion() {
	}

	public Ubicacion(Ciudad ciudad_fk, String direccion, List<Usuario> usuarios) {
		this.ciudad_fk = ciudad_fk;
		this.direccion = direccion;
		this.usuario = usuarios;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Long getUbicacion_pk() {
		return ubicacion_pk;
	}

	public void setUbicacion_pk(Long ubicacion_pk) {
		this.ubicacion_pk = ubicacion_pk;
	}

	public Ciudad getCiudad_fk() {
		return ciudad_fk;
	}

	public void setCiudad_fk(Ciudad ciudad_fk) {
		this.ciudad_fk = ciudad_fk;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
