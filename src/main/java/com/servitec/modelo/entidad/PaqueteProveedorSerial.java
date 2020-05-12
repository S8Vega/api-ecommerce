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
@Table(name = "paquete_proveedor_serial")
public class PaqueteProveedorSerial implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paquete_proveedor_serial_pk")
	private Long PaqueteProveedorSerial_pk;
	@OneToOne
	@JoinColumn(name = "serial_fk")
	@JsonIgnoreProperties(value = { "serial", "fechaEntrada", "metodoEntrada", "controlCalidad", "salida", "prestamo",
			"paqueteClienteSerial", "paqueteProveedorSerial" })
	private Serial serial_fk;
	@OneToOne
	@JoinColumn(name = "paqueteProveedor_fk")
	@JsonIgnoreProperties(value = { "pedidoProveedor_fk", "paquete_fk", "paqueteProveedorSerial" })
	private PaqueteProveedor paqueteProveedor_fk;
	private static final long serialVersionUID = 1L;

	public PaqueteProveedorSerial() {
	}

	public PaqueteProveedorSerial(Serial serial_fk, PaqueteProveedor paqueteProveedor_fk) {
		this.serial_fk = serial_fk;
		this.paqueteProveedor_fk = paqueteProveedor_fk;
	}

	public Long getPaqueteProveedorSerial_pk() {
		return PaqueteProveedorSerial_pk;
	}

	public void setPaqueteProveedorSerial_pk(Long paqueteProveedorSerial_pk) {
		PaqueteProveedorSerial_pk = paqueteProveedorSerial_pk;
	}

	public Serial getSerial_fk() {
		return serial_fk;
	}

	public void setSerial_fk(Serial serial_fk) {
		this.serial_fk = serial_fk;
	}

	public PaqueteProveedor getPaqueteProveedor_fk() {
		return paqueteProveedor_fk;
	}

	public void setPaqueteProveedor_fk(PaqueteProveedor paqueteProveedor_fk) {
		this.paqueteProveedor_fk = paqueteProveedor_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
