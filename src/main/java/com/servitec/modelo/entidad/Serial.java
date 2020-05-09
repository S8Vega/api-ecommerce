package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "serial")
public class Serial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serial_pk;
	
    @Column(name = "serial", length = 20, nullable = false, unique = true)
	private String serial;
	
    
	private Long paqueteProveedor;
	
	@Column(name = "fecha_entrada", nullable = false)
	private LocalDate fechaEntrada;
	
	@Column(name = "metodo_entrada", nullable = false)
	private String metodoEntrada;
	
	@Column(name = "control_calidad")
	private Boolean controlCalidad;
	
	@OneToOne(mappedBy = "serial_fk")
	private Salida salida;
	
	@OneToMany(mappedBy = "serial_fk")
	private List<Prestamo> prestamos;
	
	public Serial() {
		super();
	}

	public Serial(Long serial_pk, String serial, Long paqueteProveedor, LocalDate fechaEntrada, String metodoEntrada,
			Boolean controlCalidad) {
		this.serial_pk = serial_pk;
		this.serial = serial;
		this.paqueteProveedor = paqueteProveedor;
		this.fechaEntrada = fechaEntrada;
		this.metodoEntrada = metodoEntrada;
		this.controlCalidad = controlCalidad;
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

	public Long getPaqueteProveedor() {
		return paqueteProveedor;
	}

	public void setPaqueteProveedor(Long paqueteProveedor) {
		this.paqueteProveedor = paqueteProveedor;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
	
}
