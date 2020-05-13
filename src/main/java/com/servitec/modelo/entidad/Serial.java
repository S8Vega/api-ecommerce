package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "serial")
public class Serial implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serial_pk;
	@Column(name = "serial", length = 20, nullable = false, unique = true)
	private String serial;
	@Column(name = "fecha_entrada", nullable = false)
	private LocalDate fechaEntrada;
	@Column(name = "metodo_entrada", nullable = false)
	private String metodoEntrada;
	@Column(name = "control_calidad")
	private Boolean controlCalidad;
	@OneToOne(mappedBy = "serial_fk")
	@JsonIgnoreProperties(value = { "serial_fk", "fechaSalida", "motivoSalida" })
	private Salida salida;
	@OneToMany(mappedBy = "serial_fk")
	@JsonIgnoreProperties(value = { "empleado_fk", "serial_fk", "motivo", "observacionInicio", "observacionFin",
			"fechaInicio", "fechaFin" })
	private Set<Prestamo> prestamo;
	@OneToOne(mappedBy = "serial_fk")
	@JsonIgnoreProperties(value = { "serial_fk", "paqueteCliente_fk" })
	private PaqueteClienteSerial paqueteClienteSerial;
	@OneToOne(mappedBy = "serial_fk")
	@JsonIgnoreProperties(value = { "serial_fk", "paqueteProveedor_fk" })
	private PaqueteProveedorSerial paqueteProveedorSerial;
	private static final long serialVersionUID = 1L;

	public Serial() {
	}

	public Serial(String serial, LocalDate fechaEntrada, String metodoEntrada, Boolean controlCalidad, Salida salida,
			Set<Prestamo> prestamo, PaqueteClienteSerial paqueteClienteSerial,
			PaqueteProveedorSerial paqueteProveedorSerial) {
		super();
		this.serial = serial;
		this.fechaEntrada = fechaEntrada;
		this.metodoEntrada = metodoEntrada;
		this.controlCalidad = controlCalidad;
		this.salida = salida;
		this.prestamo = prestamo;
		this.paqueteClienteSerial = paqueteClienteSerial;
		this.paqueteProveedorSerial = paqueteProveedorSerial;
	}

	public Long getSerial_pk() {
		return serial_pk;
	}

	public void setSerial_pk(Long serial_pk) {
		this.serial_pk = serial_pk;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getMetodoEntrada() {
		return metodoEntrada;
	}

	public void setMetodoEntrada(String metodoEntrada) {
		this.metodoEntrada = metodoEntrada;
	}

	public Boolean getControlCalidad() {
		return controlCalidad;
	}

	public void setControlCalidad(Boolean controlCalidad) {
		this.controlCalidad = controlCalidad;
	}

	public Salida getSalida() {
		return salida;
	}

	public void setSalida(Salida salida) {
		this.salida = salida;
	}

	public Set<Prestamo> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Set<Prestamo> prestamo) {
		this.prestamo = prestamo;
	}

	public PaqueteClienteSerial getPaqueteClienteSerial() {
		return paqueteClienteSerial;
	}

	public void setPaqueteClienteSerial(PaqueteClienteSerial paqueteClienteSerial) {
		this.paqueteClienteSerial = paqueteClienteSerial;
	}

	public PaqueteProveedorSerial getPaqueteProveedorSerial() {
		return paqueteProveedorSerial;
	}

	public void setPaqueteProveedorSerial(PaqueteProveedorSerial paqueteProveedorSerial) {
		this.paqueteProveedorSerial = paqueteProveedorSerial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
