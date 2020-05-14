package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "obra")
public class Obra implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long obra_pk;
	@Column(name = "nombre", length = 100)
	private String nombre;
	@OneToMany(mappedBy = "obra_fk", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "obra_fk", "empleado_fk", "fechaInicio", "fechaFin" })
	private Set<Trabaja> trabaja;
	private static final long serialVersionUID = 1L;

	public Obra() {
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

	public Set<Trabaja> getTrabaja() {
		return trabaja;
	}

	public void setTrabaja(Set<Trabaja> trabaja) {
		this.trabaja = trabaja;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
