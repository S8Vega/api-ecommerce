package com.servitec.modelo.entidad;

import java.io.Serializable;

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
@Table(name = "aliado")
public class Aliado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aliado_pfk;
	@OneToOne
	@JoinColumn(name = "usuario")
	@JsonIgnoreProperties("aliado")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "tipoDoc")
	@JsonIgnoreProperties("aliado")
	private TipoDoc tipoDoc;
	private String documento;
	private static final long serialVersionUID = 1L;

	public Aliado() {
	}

	public Aliado(Usuario usuario, TipoDoc tipoDoc, String documento) {
		this.usuario = usuario;
		this.tipoDoc = tipoDoc;
		this.documento = documento;
	}

	public Long getAliado_pfk() {
		return aliado_pfk;
	}

	public void setAliado_pfk(Long aliado_pfk) {
		this.aliado_pfk = aliado_pfk;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoDoc getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDoc tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
