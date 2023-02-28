package com.javaplatzispring.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaplatzispring.app.domain.domain.Product;
import com.javaplatzispring.app.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	public List<Product> getAll(){
		return productService.getAll();
	}
	
	public Optional<Product> getProduct(Long idProduct){
		return productService.getProduct(idProduct);
	}
	
	public Optional<List<Product>> getByCategory(Long categoryId){
		return productService.getByCategory(categoryId);
	}
	
	public Product save(Product product) {
		return productService.save(product);
	}
	
	public boolean delete(Long idProduct) {
		return productService.delete(idProduct);
	}
}
