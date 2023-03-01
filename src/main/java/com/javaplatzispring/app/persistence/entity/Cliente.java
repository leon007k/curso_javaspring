package com.javaplatzispring.app.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	private String id;
	
	private String nombre;
	
	private String apellidos;
	
	private Long celular;
	
	private String direccion;
	
	@Column(name = "correo_electronico")
	private String email;
	
	@OneToMany(mappedBy = "cliente")
	private List<Compra> compras;
}
