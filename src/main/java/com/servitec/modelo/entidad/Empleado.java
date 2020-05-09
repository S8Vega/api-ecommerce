package com.servitec.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public static long getSerialversionuid() {
	return serialVersionUID;
}

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long empleado_pk;
   
   @OneToOne
   @JoinColumn(name = "empleado_fk")
   @JsonIgnoreProperties("empleado_fk")
   private Usuario empleado_fk;
   
   @Column(name = "alias", length = 50, nullable = false, unique = true)
   private String alias;
   
   @Column(name = "contrasena", length = 25, nullable = false)
   private String contrasena;
   
   @ManyToOne
   @JoinColumn(name = "cargo_fk")
   @JsonIgnoreProperties("empleado")
   private Cargo cargo_fk;
   
   @OneToMany(mappedBy = "empleado_fk")
   private List<Trabaja> trabaja;
   
   @OneToMany(mappedBy = "empleado_fk")
   private List<Prestamo> prestamo;

public Empleado(Usuario empleado_fk, String alias, String contrasena, Cargo cargo_fk) {
	this.empleado_fk = empleado_fk;
	this.alias = alias;
	this.contrasena = contrasena;
	this.cargo_fk = cargo_fk;
}

public Empleado() {
}



public Long getEmpleado_pk() {
	return empleado_pk;
}

public void setEmpleado_pk(Long empleado_pk) {
	this.empleado_pk = empleado_pk;
}

public Usuario getEmpleado_fk() {
	return empleado_fk;
}

public void setEmpleado_fk(Usuario empleado_fk) {
	this.empleado_fk = empleado_fk;
}

public String getAlias() {
	return alias;
}

public void setAlias(String alias) {
	this.alias = alias;
}

public String getContrasena() {
	return contrasena;
}

public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
}

public Cargo getCargo_fk() {
	return cargo_fk;
}

public void setCargo_fk(Cargo cargo_fk) {
	this.cargo_fk = cargo_fk;
}

public List<Trabaja> getTrabaja() {
	return trabaja;
}

public void setTrabaja(List<Trabaja> trabaja) {
	this.trabaja = trabaja;
}

public List<Prestamo> getPrestamo() {
	return prestamo;
}

public void setPrestamo(List<Prestamo> prestamo) {
	this.prestamo = prestamo;
}
   
 

}
