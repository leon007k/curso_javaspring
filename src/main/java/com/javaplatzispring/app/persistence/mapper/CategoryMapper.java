package com.javaplatzispring.app.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.javaplatzispring.app.domain.domain.Category;
import com.javaplatzispring.app.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	@Mapping(source = "idCategoria", target = "categoryId")
	@Mapping(source = "descripcion", target = "category")
	@Mapping(source = "estado", target = "active")
	Category toCategory(Categoria categoria);
	
	//* Mapeo inverso
	@InheritInverseConfiguration
	@Mapping(target =  "productos", ignore = true)
	Categoria toCategoria(Category category);
}
