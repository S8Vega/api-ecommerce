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
@Table(name = "usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuario_pk;
	@Column(length = 100, nullable = false)
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "ubicacion_fk")
	@JsonIgnoreProperties(value = { "ciudad_fk", "direccion", "usuario" })
	private Ubicacion ubicacion_fk;
	@Column(length = 20)
	private String telefono;
	@Column(length = 120, unique = true, nullable = false)
	private String correo;
	@OneToOne(mappedBy = "usuario_fk", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "usuario_fk", "tipoDoc_fk", "documento", "pedidoCliente", "pedidoProveedor" })
	private Aliado aliado;
	@OneToOne(mappedBy = "usuario_fk", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "usuario_fk", "alias", "contrasena" })
	private Administrador administrador;
	@OneToOne(mappedBy = "usuario_fk", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "usuario_fk", "alias", "contrasena", "cargo_fk", "trabaja", "prestamo" })
	private Empleado empleado;
	private static final long serialVersionUID = 1L;

	public Usuario() {
	}

	public Usuario(String nombre, Ubicacion ubicacion_fk, String telefono, String correo, Aliado aliado,
			Administrador administrador, Empleado empleado) {
		this.nombre = nombre;
		this.ubicacion_fk = ubicacion_fk;
		this.telefono = telefono;
		this.correo = correo;
		this.aliado = aliado;
		this.administrador = administrador;
		this.empleado = empleado;
	}

	public Aliado getAliado() {
		return aliado;
	}

	public void setAliado(Aliado aliado) {
		this.aliado = aliado;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Long getUsuario_pk() {
		return usuario_pk;
	}

	public void setUsuario_pk(Long usuario_pk) {
		this.usuario_pk = usuario_pk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ubicacion getUbicacion_fk() {
		return ubicacion_fk;
	}

	public void setUbicacion_fk(Ubicacion ubicacion_fk) {
		this.ubicacion_fk = ubicacion_fk;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
