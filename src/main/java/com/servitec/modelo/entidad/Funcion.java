package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcion")
public class Funcion implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcion_pk;
	@Column(length = 100, nullable = false)
	private String nombre;
	@ManyToMany(mappedBy = "funciones", fetch = FetchType.EAGER)
    private List<Producto> productos;
	
	private static final long serialVersionUID = 1L;
	
	public Funcion() {
	}
	
	public Funcion(String nombre, List<Producto> productos) {
		this.nombre = nombre;
		this.productos = productos;
	}

	public Long getFuncion_pk() {
		return funcion_pk;
	}

	public void setFuncion_pk(Long funcion_pk) {
		this.funcion_pk = funcion_pk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
