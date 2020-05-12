package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long producto_pk;
	@Column(length = 100, nullable = false)
	private String nombre;
	@Column(length = 100, nullable = false)
	private String marca;
	@Column(length = 100, nullable = false)
	private String modelo;
	@Column(length = 100, nullable = false)
	private String ubicacion;
	@Column(name = "cantidad_minima", nullable = false)
	private Long cantidadMinima;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "producto_funcion", joinColumns = @JoinColumn(name = "producto_pfk"), inverseJoinColumns = @JoinColumn(name = "funcion_pfk"))
	@JsonIgnoreProperties(value = { "nombre", "producto" })
	private List<Funcion> funcion;
	@OneToMany(mappedBy = "producto_fk")
	@JsonIgnoreProperties(value = { "medida", "cantidadInicial", "producto_fk", "paqueteCliente", "paqueteProveedor" })
	private List<Paquete> paquete;
	private static final long serialVersionUID = 1L;

	public Producto() {
	}

	public Producto(String nombre, String marca, String modelo, String ubicacion, Long cantidadMinima,
			List<Funcion> funcion, List<Paquete> paquete) {
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.ubicacion = ubicacion;
		this.cantidadMinima = cantidadMinima;
		this.funcion = funcion;
		this.paquete = paquete;
	}

	public List<Paquete> getPaquete() {
		return paquete;
	}

	public void setPaquete(List<Paquete> paquete) {
		this.paquete = paquete;
	}

	public Long getProducto_pk() {
		return producto_pk;
	}

	public void setProducto_pk(Long producto_pk) {
		this.producto_pk = producto_pk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Long getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Long cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public List<Funcion> getFuncion() {
		return funcion;
	}

	public void setFuncion(List<Funcion> funcion) {
		this.funcion = funcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}