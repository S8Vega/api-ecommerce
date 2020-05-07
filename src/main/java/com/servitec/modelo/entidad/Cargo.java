package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cargo_pk;
	
	@Column(name = "nombre", length = 30, nullable = false, unique = true)
	private String nombre;
	@OneToMany(mappedBy = "cargo_fk")
	private List<Empleado> empleado;

	public Cargo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cargo(Long cargo_pk, String nombre) {
		this.cargo_pk = cargo_pk;
		this.nombre = nombre;
	}

	public Long getCargo_pk() {
		return cargo_pk;
	}

	public void setCargo_pk(Long cargo_pk) {
		this.cargo_pk = cargo_pk;
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

	public List<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}
	
	

}
