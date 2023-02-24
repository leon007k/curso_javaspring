package com.javaplatzispring.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.javaplatzispring.app.domain.domain.Product;
import com.javaplatzispring.app.persistence.entity.Producto;

/*
 * Con uses, indicamos que debera hacer uso de la clase que contiene el otro mapper
 * debido a que la clase producto tiene un join con la clase categoria
 * */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

	@Mapping(source = "idProducto", target = "productId")
	@Mapping(source = "nombre", target = "name")
	@Mapping(source = "idCategoria", target = "categoryId")
	@Mapping(source = "precioVenta", target = "price")
	@Mapping(source = "cantidadStock", target = "stock")
	@Mapping(source = "estado", target = "active")
	@Mapping(source = "categoria", target = "category")
	Product toProduct(Producto producto);
	
	List<Product> toProducts(List<Producto> productos);
	
	@InheritInverseConfiguration
	@Mapping(target = "codigoBarras", ignore = true)
	Producto toProduct(Product product);
}
