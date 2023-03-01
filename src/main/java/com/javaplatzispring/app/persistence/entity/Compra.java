package com.javaplatzispring.app.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private long idCompra;
	
	@Column(name = "id_cliente")
	private String idCliente;
	
	private LocalDateTime fecha;
	
	@Column(name = "medio_pago")
	private String mediopago;
	
	private String comentario;
	
	private Boolean estado;
	
	/* indicamos la relacion y agregamos que no permita crear nuevos clientes apartir
		de esta relacion */
	@ManyToOne
	@JoinColumn(name = "id_cliente", insertable = false, updatable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "compra")
	private List<CompraProducto> productos;
}
