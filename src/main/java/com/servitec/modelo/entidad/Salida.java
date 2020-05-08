package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salida")
public class Salida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salida;
	
	@OneToOne
	@JoinColumn(name = "serial_fk")
	private Serial serial_fk;
	
	@Column(name = "fecha_salida", nullable = false)
	private LocalDate fechaSalida;
	
	@Column(name = "motivo_salida", length = 20)
	private String motivoSalida;

	public Salida() {
		super();
	}

	public Salida(Serial serial_fk, LocalDate fechaSalida, String motivoSalida) {
		this.serial_fk = serial_fk;
		this.fechaSalida = fechaSalida;
		this.motivoSalida = motivoSalida;
	}
	
	

	public Long getSalida() {
		return salida;
	}

	public void setSalida(Long salida) {
		this.salida = salida;
	}

	public Serial getSerial_fk() {
		return serial_fk;
	}

	public void setSerial_fk(Serial serial_fk) {
		this.serial_fk = serial_fk;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getMotivoSalida() {
		return motivoSalida;
	}

	public void setMotivoSalida(String motivoSalida) {
		this.motivoSalida = motivoSalida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
