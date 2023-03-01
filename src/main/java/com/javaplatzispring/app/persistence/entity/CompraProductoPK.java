package com.javaplatzispring.app.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class CompraProductoPK implements Serializable{

	@Column(name = "id_compra")
	private Long idCompra;
	
	@Column(name = "id_producto")
	private Long idProducto;
}
