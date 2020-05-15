package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "administrador")
public class Administrador implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long administrador_pk;
	@OneToOne
	@JoinColumn(name = "usuario_fk", unique = true)
	@JsonIgnoreProperties(value = { "nombre", "ubicacion_fk", "telefono", "correo", "aliado", "administrador",
			"empleado" }, allowSetters = true)
	private Usuario usuario_fk;
	@Column(name = "alias", length = 50, nullable = false, unique = true)
	private String alias;
	@Column(name = "contrasena", length = 250, nullable = false)
	private String contrasena;
	private static final long serialVersionUID = 1L;

	public Administrador() {
	}

	public Administrador(Usuario usuario_fk, String alias, String contrasena) {
		this.usuario_fk = usuario_fk;
		this.alias = alias;
		this.contrasena = contrasena;
	}

	public Long getAdministrador_pk() {
		return administrador_pk;
	}

	public void setAdministrador_pk(Long administrador_pk) {
		this.administrador_pk = administrador_pk;
	}

	public Usuario getUsuario_fk() {
		return usuario_fk;
	}

	public void setUsuario_fk(Usuario usuario_fk) {
		this.usuario_fk = usuario_fk;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
