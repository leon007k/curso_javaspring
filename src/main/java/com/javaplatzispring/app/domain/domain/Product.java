package com.javaplatzispring.app.domain.domain;

import javax.money.MonetaryAmount;

import lombok.Data;

@Data
public class Product {

	private Long productId;
	private String name;
	private Long categoryId;
	private MonetaryAmount price;
	private Integer stock;
	private Boolean active;
	private Category category;
}
