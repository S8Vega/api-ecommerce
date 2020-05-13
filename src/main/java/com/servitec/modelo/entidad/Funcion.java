package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "funcion")
public class Funcion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcion_pk;
	@Column(length = 100, nullable = false)
	private String nombre;
	@ManyToMany(mappedBy = "funcion",fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value = { "nombre", "marca", "modelo", "ubicacion", "cantidadMinima", "funcion", "paquete" })
	private Set<Producto> producto;

	private static final long serialVersionUID = 1L;

	public Funcion() {
	}

	public Funcion(String nombre, Set<Producto> producto) {
		this.nombre = nombre;
		this.producto = producto;
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

	public Set<Producto> getProducto() {
		return producto;
	}

	public void setProducto(Set<Producto> producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
