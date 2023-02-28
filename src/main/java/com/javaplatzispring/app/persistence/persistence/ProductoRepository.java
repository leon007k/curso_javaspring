package com.javaplatzispring.app.persistence.persistence;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaplatzispring.app.domain.domain.Product;
import com.javaplatzispring.app.domain.repository.ProductRepository;
import com.javaplatzispring.app.persistence.crud.ProductoCrudRepository;
import com.javaplatzispring.app.persistence.entity.Producto;
import com.javaplatzispring.app.persistence.mapper.ProductMapper;


@Repository
public class ProductoRepository implements ProductRepository {

	@Autowired
	private ProductoCrudRepository productoCrudRepository;

	@Autowired
	private ProductMapper mapper;
	
	/*
	 * Con este cambio, logramos que nuestro programa este enfocado al dominio
	 * y no a una tabla en especifico. Logrando que este no se acople a una bd
	 * puntual
	 * 
	 * public List<Producto> getAllProducts(){
		return (List<Producto>) productoCrudRepository.findAll();
	}
	
	public List<Producto> getByCategoria(Long idCategoria){
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
	}*/
	
	/**
	 * @param producto
	 * @return
	 */
	private Optional<List<Product>> extracted(Optional<List<Producto>> producto) {
		return producto.map(prod -> mapper.toProducts(prod));
	}
	
	@Override
	public void delete(Long idProduct) {
		productoCrudRepository.deleteById(idProduct);
	}
	
	@Override
	public Optional<List<Product>> getProductDataByName(String name){
		 Optional<List<Producto>> producto = productoCrudRepository.findByNombreLike(name);
		 return extracted(producto);
	}
	
	@Override
	public Optional<List<Product>> getProductsByBetweenPriceSell(int priceS, int priceE){
		Optional<List<Producto>> producto = productoCrudRepository.findByprecioVentaBetween(priceS, priceE);
		return extracted(producto);
	}
	
	@Override
	public Optional<List<Product>> getProductsByStartingLetter(String letter){
		Optional<List<Producto>> producto = productoCrudRepository.findByNombreStartingWith(letter);
		return extracted(producto);
	}

	@Override
	public List<Product> getAll() {
		List<Producto> producto = (List<Producto>) productoCrudRepository.findAll();
		return mapper.toProducts(producto);
	}

	@Override
	public Optional<List<Product>> getByCategory(Long categoryId) {
		List<Producto> productos =  productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return extracted(productos);
	}

	@Override
	public Optional<Product> getProduct(Long idProduct) {
		return productoCrudRepository.findById(idProduct).map(
				product -> mapper.toProduct(product));
	}

	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoCrudRepository.save(producto));
	}
	
}
