package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trabaja")
public class Trabaja implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trabaja_pk;
	
	@ManyToOne
	@JoinColumn(name = "obra_fk")
	private Obra obra_fk;
	
	@ManyToOne
	@JoinColumn(name = "empleado_fk")
	private Empleado empleado_fk;
	
	@Column(name = "fecha_inicio", nullable = false)
	private LocalDate fechaInicio;
	
	@Column(name = "fecha_fin", nullable = false)
	private LocalDate fechaFin;

	public Trabaja() {
		super();
	}

	public Trabaja(Long trabaja_pk, Obra obra_fk, Empleado empleado_fk, LocalDate fechaInicio, LocalDate fechaFin) {
		this.trabaja_pk = trabaja_pk;
		this.obra_fk = obra_fk;
		this.empleado_fk = empleado_fk;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Long getTrabaja_pk() {
		return trabaja_pk;
	}

	public void setTrabaja_pk(Long trabaja_pk) {
		this.trabaja_pk = trabaja_pk;
	}

	public Obra getObra_fk() {
		return obra_fk;
	}

	public void setObra_fk(Obra obra_fk) {
		this.obra_fk = obra_fk;
	}

	public Empleado getEmpleado_fk() {
		return empleado_fk;
	}

	public void setEmpleado_fk(Empleado empleado_fk) {
		this.empleado_fk = empleado_fk;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
