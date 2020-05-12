package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipo_doc")
public class TipoDoc implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipoDoc_pk;
	@Column(length = 30, nullable = false, unique = true)
	private String nombre;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tipoDoc_fk")
	@JsonIgnoreProperties(value = { "usuario_fk", "tipoDoc_fk", "documento", "pedidoCliente", "pedidoProveedor" })
	private List<Aliado> aliado;
	private static final long serialVersionUID = 1L;

	public TipoDoc() {
	}

	public TipoDoc(String nombre, List<Aliado> aliado) {
		this.nombre = nombre;
		this.aliado = aliado;
	}

	public Long getTipoDoc_pk() {
		return tipoDoc_pk;
	}

	public void setTipoDoc_pk(Long tipoDoc_pk) {
		this.tipoDoc_pk = tipoDoc_pk;
	}

	public List<Aliado> getAliado() {
		return aliado;
	}

	public void setAliado(List<Aliado> aliado) {
		this.aliado = aliado;
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
