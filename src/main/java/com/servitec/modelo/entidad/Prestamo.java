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
@Table(name = "prestamo")
public class Prestamo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prestamo_pk;
	
	@ManyToOne
	@JoinColumn(name = "empleado_fk")
	private Empleado empleado_fk;
	
	@ManyToOne()
	@JoinColumn(name = "serial_fk")
	private Serial serial_fk;
	
	@Column(name = "motivo", length = 200, nullable = false)
	private String motivo;
	
	@Column(name = "observacion_inicio", length = 200)
	private String observacionInicio;
	
	@Column(name = "observacion_fin", length = 200)
	private String observacionFin;
	
	@Column(name = "fecha_inicio", nullable = false)
	private LocalDate fechaInicio;
	
	@Column(name = "fecha_fin")
	private LocalDate fechaFin;
	
	public Prestamo() {
		super();
	}

	public Prestamo(Long prestamo_pk, Empleado empleado_fk, Serial serial_fk, String motivo, String observacionInicio,
			String observacionFin, LocalDate fechaInicio, LocalDate fechaFin) {
		this.prestamo_pk = prestamo_pk;
		this.empleado_fk = empleado_fk;
		this.serial_fk = serial_fk;
		this.motivo = motivo;
		this.observacionInicio = observacionInicio;
		this.observacionFin = observacionFin;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Long getPrestamo_pk() {
		return prestamo_pk;
	}

	public void setPrestamo_pk(Long prestamo_pk) {
		this.prestamo_pk = prestamo_pk;
	}

	public Empleado getEmpleado_fk() {
		return empleado_fk;
	}

	public void setEmpleado_fk(Empleado empleado_fk) {
		this.empleado_fk = empleado_fk;
	}

	public Serial getSerial_fk() {
		return serial_fk;
	}

	public void setSerial_fk(Serial serial_fk) {
		this.serial_fk = serial_fk;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacionInicio() {
		return observacionInicio;
	}

	public void setObservacionInicio(String observacionInicio) {
		this.observacionInicio = observacionInicio;
	}

	public String getObservacionFin() {
		return observacionFin;
	}

	public void setObservacionFin(String observacionFin) {
		this.observacionFin = observacionFin;
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
