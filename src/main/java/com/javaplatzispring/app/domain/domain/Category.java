package com.javaplatzispring.app.domain.domain;

import lombok.Data;

@Data
public class Category {

	private Long categoryId;
	private String category;
	private Boolean active;
}
