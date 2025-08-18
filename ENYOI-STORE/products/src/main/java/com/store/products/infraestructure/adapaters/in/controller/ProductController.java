package com.store.products.infraestructure.adapaters.in.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.products.domain.ports.in.ProductUsesCases;
import com.store.products.infraestructure.adapaters.in.dto.ProductRequestDto;
import com.store.products.infraestructure.adapaters.in.dto.ProductResponseDto;
import com.store.products.infraestructure.mapper.ProductMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUsesCases usesCases;
    private final ProductMapper mapper;

    @PostMapping
    public Mono<ProductResponseDto> createProduct(@Valid@RequestBody ProductRequestDto productRequestDto){
        return usesCases.createProduct(mapper.toDomain(productRequestDto)).map(mapper::toResponseDto);
    }
    @GetMapping("/{productId}")
    public Mono<ProductResponseDto> getProductById(@PathVariable Long productId){
        return usesCases.getProductById(productId).map(mapper::toResponseDto);
    }
    @PutMapping("/{productId}")
    public Mono<ProductResponseDto> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductRequestDto productRequestDto){
        return usesCases.updateProduct(productId, mapper.toDomain(productRequestDto)).map(mapper::toResponseDto);
    }
    @GetMapping
    public Flux<ProductResponseDto> getAllProducts(){
        return usesCases.getAllProducts().map(mapper::toResponseDto);
    }
    @DeleteMapping("/{productId}")
    public Mono<Void> deleteProduct(@PathVariable Long productId){
        return usesCases.deleteProduct(productId);
    }

}
