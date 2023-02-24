package com.javaplatzispring.app.persistence.entity;

import javax.money.MonetaryAmount;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "compras_productos")
public class CompraProducto {
	
	@EmbeddedId
	private CompraProductoPK id;
	
	private Long cantidad;
	
	private MonetaryAmount total;
	
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_compra", insertable = false, updatable = false)
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", insertable = false, updatable = false)
	private Producto producto;
}
