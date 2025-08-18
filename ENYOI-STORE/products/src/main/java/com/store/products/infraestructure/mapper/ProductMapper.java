package com.store.products.infraestructure.mapper;
import org.springframework.stereotype.Component;

import com.store.products.domain.models.Product;
import com.store.products.infraestructure.adapaters.in.dto.ProductRequestDto;
import com.store.products.infraestructure.adapaters.in.dto.ProductResponseDto;
import com.store.products.infraestructure.adapaters.out.entity.ProductEntity;

@Component
public class ProductMapper {
    /*Persistence Mapper
    */ 
    public Product toDomain(ProductEntity productEntity){
        return new Product(
        productEntity.getId(),
        productEntity.getName(), 
        productEntity.getCategory(), 
        productEntity.getDescription(),
        productEntity.getPrice(), 
        productEntity.getStock());
    };

    public ProductEntity toEntity(Product product){
        return new ProductEntity(
            product.getId(),
            product.getName(),
            product.getCategory(), 
            product.getDescription(), 
            product.getPrice(), 
            product.getStock());
    }

    /*
     * Web Mapper
    */

    public Product toDomain(ProductRequestDto productRequestDto){
        return new Product(
            null, // or provide an id if available
            productRequestDto.getName(), 
            productRequestDto.getCategory(), 
            productRequestDto.getDescription(),
            productRequestDto.getPrice(), 
            productRequestDto.getStock());
    }
    public ProductResponseDto toResponseDto(Product product){
        return new ProductResponseDto(
            product.getId(),
            product.getName(),
            product.getCategory(),
            product.getDescription(),
            product.getPrice(),
            product.getStock());
    }

}
