package com.javaplatzispring.app.persistence.crud;

import java.util.List;
import java.util.Optional;

import javax.money.MonetaryAmount;

import org.springframework.data.repository.CrudRepository;

import com.javaplatzispring.app.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Long>{

	// Esta es una forma de como poder usar querys en forma de metodos
	/*@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
	List<Producto> getByCategoria(int idCategoria);*/
	
	Optional<List<Producto>> findByIdCategoriaOrderByNombreAsc(Long idCategoria);
	
	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, 
			boolean estado);
	
	Optional<List<Producto>> findByNombreLike(String nombre);
	
	Optional<List<Producto>> findByprecioVentaBetween(MonetaryAmount precioVentaS, 
			MonetaryAmount precioVentaF);
	
	Optional<List<Producto>> findByNombreStartingWith(String nombre);
}