package com.javaplatzispring.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaplatzispring.app.domain.domain.Product;
import com.javaplatzispring.app.domain.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAll(){
		return productRepository.getAll();
	}
	
	public Optional<Product> getProduct(Long idProduct){
		return productRepository.getProduct(idProduct);
	}
	
	public Optional<List<Product>> getByCategory(Long categoryId){
		return productRepository.getByCategory(categoryId);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public boolean delete(Long idProduct) {
		return getProduct(idProduct).map(product -> {
			productRepository.delete(idProduct);
			return true;
		}).orElse(false);
	}
}
