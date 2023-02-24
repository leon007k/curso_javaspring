package com.javaplatzispring.app.persistence.persistence;

import java.util.List;
import java.util.Optional;

import javax.money.MonetaryAmount;

import org.springframework.stereotype.Repository;

import com.javaplatzispring.app.persistence.crud.ProductoCrudRepository;
import com.javaplatzispring.app.persistence.entity.Producto;

@Repository
public class ProductoRepository {

	private ProductoCrudRepository productoCrudRepository;
	
	public List<Producto> getAllProducts(){
		return (List<Producto>) productoCrudRepository.findAll();
	}
	
	public Optional<List<Producto>> getByCategoria(Long idCategoria){
		return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
	}
	
	public Optional<List<Producto>> getEscasos(int cantidad){
		return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
	}
	
	public Optional<Producto> getProductoById(Long idProducto){
		return productoCrudRepository.findById(idProducto);
	}
	
	public Producto save(Producto producto) {
		return productoCrudRepository.save(producto);
	}
	
	public void delete(Long idProducto) {
		productoCrudRepository.deleteById(idProducto);
	}
	
	public Optional<List<Producto>> getProductDataByName(String nombre){
		return productoCrudRepository.findByNombreLike(nombre);
	}
	
	public Optional<List<Producto>> getProductsByBetweenPriceSell(MonetaryAmount precioVentaS, MonetaryAmount precioVentaF){
		return productoCrudRepository.findByprecioVentaBetween(precioVentaS, precioVentaF);
	}
	
	public Optional<List<Producto>> getProductsByStartingLetter(String letra){
		return productoCrudRepository.findByNombreStartingWith(letra);
	}
	
}
