package com.javaplatzispring.app.domain.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private Long productId;
	private String name;
	private Long categoryId;
	private int price;
	private Integer stock;
	private Boolean active;
	private Category category;
}
