package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.JoinColumn;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{
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
	@Column (name = "cantidad_minima", nullable = false)
	private int cantidadMinima;
	//@OneToMany(cascade = CascadeType.UPDATE, fetch = FetchType.LAZY, mappedBy = "producto_fk")
	//private List<Paquete> paquete;
	@JoinTable(
	        name = "producto_funcion",
	        joinColumns = @JoinColumn(name = "producto_pfk", nullable = false),
	        inverseJoinColumns = @JoinColumn(name = "funcion_pfk", nullable = false)
	    )
	    @ManyToMany
	    private List<Funcion> funciones;
	
	private static final long serialVersionUID = 1L;
	
	public Producto() {
	}
	
	public Producto(String nombre, String marca, String modelo, String ubicacion, int cantidadMinima, List<Funcion> funciones) {
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.ubicacion = ubicacion;
		this.cantidadMinima = cantidadMinima;
		this.funciones = funciones;
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

	public int getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	/*public List<Paquete> getPaquete() {
		return paquete;
	}

	public void setPaquete(List<Paquete> paquete) {
		this.paquete = paquete;
	}*/
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	
}