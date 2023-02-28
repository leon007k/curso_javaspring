package com.javaplatzispring.app.domain.domain;


import lombok.Data;

@Data
public class Product {

	private Long productId;
	private String name;
	private Long categoryId;
	private int price;
	private Integer stock;
	private Boolean active;
	private Category category;
}
