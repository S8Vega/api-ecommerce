package com.servitec.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name = "administrador_fk")
	private Usuario administrador_fk;
	
	@Column(name = "alias", length = 50, nullable = false, unique = true)
	private String alias;
	
	@Column(name = "contrasena", length = 25, nullable = false)
	private String contrasena;

	public Administrador() {
	}

	public Administrador(Usuario administrador_fk, String alias, String contrasena) {
		this.administrador_fk = administrador_fk;
		this.alias = alias;
		this.contrasena = contrasena;
	}

	public Usuario getAdministrador_fk() {
		return administrador_fk;
	}

	public void setAdministrador_fk(Usuario administrador_fk) {
		this.administrador_fk = administrador_fk;
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
	
	
}
