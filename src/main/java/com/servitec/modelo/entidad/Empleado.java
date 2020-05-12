package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empleado_pk;
	@OneToOne
	@JoinColumn(name = "usuario_fk")
	@JsonIgnoreProperties(value = { "nombre", "ubicacion_fk", "telefono", "correo", "aliado", "administrador",
			"empleado" })
	private Usuario usuario_fk;
	@Column(name = "alias", length = 50, nullable = false, unique = true)
	private String alias;
	@Column(name = "contrasena", length = 25, nullable = false)
	private String contrasena;
	@ManyToOne
	@JoinColumn(name = "cargo_fk")
	@JsonIgnoreProperties(value = { "nombre", "empleado" })
	private Cargo cargo_fk;
	@OneToMany(mappedBy = "empleado_fk")
	@JsonIgnoreProperties(value = { "obra_fk", "empleado_fk", "fechaInicio", "fechaFin" })
	private Set<Trabaja> trabaja;
	@OneToMany(mappedBy = "empleado_fk")
	@JsonIgnoreProperties(value = { "empleado_fk", "serial_fk", "motivo", "observacionInicio", "observacionFin",
			"fechaInicio", "fechaFin" })
	private Set<Prestamo> prestamo;
	private static final long serialVersionUID = 1L;

	public Empleado() {
	}

	public Empleado(Usuario usuario_fk, String alias, String contrasena, Cargo cargo_fk, Set<Trabaja> trabaja,
			Set<Prestamo> prestamo) {
		super();
		this.usuario_fk = usuario_fk;
		this.alias = alias;
		this.contrasena = contrasena;
		this.cargo_fk = cargo_fk;
		this.trabaja = trabaja;
		this.prestamo = prestamo;
	}

	public Long getEmpleado_pk() {
		return empleado_pk;
	}

	public void setEmpleado_pk(Long empleado_pk) {
		this.empleado_pk = empleado_pk;
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

	public Cargo getCargo_fk() {
		return cargo_fk;
	}

	public void setCargo_fk(Cargo cargo_fk) {
		this.cargo_fk = cargo_fk;
	}

	public Set<Trabaja> getTrabaja() {
		return trabaja;
	}

	public void setTrabaja(Set<Trabaja> trabaja) {
		this.trabaja = trabaja;
	}

	public Set<Prestamo> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Set<Prestamo> prestamo) {
		this.prestamo = prestamo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
