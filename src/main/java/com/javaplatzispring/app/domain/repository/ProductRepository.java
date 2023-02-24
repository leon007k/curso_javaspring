package com.javaplatzispring.app.domain.repository;

import java.util.List;
import java.util.Optional;

import javax.money.MonetaryAmount;

import com.javaplatzispring.app.domain.domain.Product;

public interface ProductRepository {

	List<Product> getAll();
	Optional<List<Product>> getByCategory(Long categoryId);
	Optional<List<Product>> getScarseProducts(int quantity);
	Optional<List<Product>> getProduct(Long idProduct);
	Product save(Product product);
	void delete(Long idProduct);
	Optional<List<Product>> getProductDataByName(String name);
	Optional<List<Product>> getProductsByBetweenPriceSell(MonetaryAmount priceS, MonetaryAmount priceE);
	Optional<List<Product>> getProductsByStartingLetter(String letter);
}
