package com.javaplatzispring.app.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

	/*
	 * @Id --> indica que esta es la clave primary de la bd
	 * GeneratedValue --> permitira que java genere el id de manera automatica
	 * @Column --> indicamos a java a que nombre de la columna sera relacionada esta variable
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long idProducto;
	
	private String nombre;
	
	@Column(name = "id_categoria")
	private Long idCategoria;
	
	@Column(name = "codigo_barras")
	private String codigoBarras;
	
	@Column(name = "precio_venta")
	private int precioVenta;
	
	@Column(name = "cantidad_stock")
	private Integer cantidadStock;
	
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", insertable = false, updatable = false)
	private Categoria categoria;	
}
