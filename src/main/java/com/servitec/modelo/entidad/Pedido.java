package com.servitec.modelo.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pedido_pk;
	
	@Column(length = 15)
	private String codigo;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "pedido_fk")
	private PedidoCliente pedidoCliente;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "pedido_fk")
	private PedidoProveedor pedidoProveedor;
}
