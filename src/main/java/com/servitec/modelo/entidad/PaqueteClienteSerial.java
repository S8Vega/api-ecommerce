package com.servitec.modelo.entidad;

import java.io.Serializable;

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
@Table(name = "paquete_cliente_serial")
public class PaqueteClienteSerial implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paquete_cliente_serial_pk")
	private Long PaqueteClienteSerial_pk;
	@OneToOne
	@JoinColumn(name = "serial_fk", unique = true)
	@JsonIgnoreProperties(value = { "serial", "fechaEntrada", "metodoEntrada", "controlCalidad", "salida", "prestamo",
			"paqueteClienteSerial", "paqueteProveedorSerial" })
	private Serial serial_fk;
	@ManyToOne
	@JoinColumn(name = "paqueteCliente_fk")
	@JsonIgnoreProperties(value = { "pedidoCliente_fk", "paquete_fk", "paqueteClienteSerial" })
	private PaqueteCliente paqueteCliente_fk;
	private static final long serialVersionUID = 1L;

	public PaqueteClienteSerial() {
	}

	public PaqueteClienteSerial(Serial serial_fk, PaqueteCliente paqueteCliente_fk) {
		this.serial_fk = serial_fk;
		this.paqueteCliente_fk = paqueteCliente_fk;
	}

	public Long getPaqueteClienteSerial_pk() {
		return PaqueteClienteSerial_pk;
	}

	public void setPaqueteClienteSerial_pk(Long paqueteClienteSerial_pk) {
		PaqueteClienteSerial_pk = paqueteClienteSerial_pk;
	}

	public Serial getSerial_fk() {
		return serial_fk;
	}

	public void setSerial_fk(Serial serial_fk) {
		this.serial_fk = serial_fk;
	}

	public PaqueteCliente getPaqueteCliente_fk() {
		return paqueteCliente_fk;
	}

	public void setPaqueteCliente_fk(PaqueteCliente paqueteCliente_fk) {
		this.paqueteCliente_fk = paqueteCliente_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
