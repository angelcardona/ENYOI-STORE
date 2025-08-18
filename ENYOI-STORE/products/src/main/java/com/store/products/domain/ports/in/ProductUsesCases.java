package com.store.products.domain.ports.in;

import com.store.products.domain.models.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductUsesCases {

    Mono<Product> createProduct(Product product);
    Mono<Product> getProductById(Long id);
    Mono<Product> updateProduct(Long productId,Product product);
    Flux<Product> getAllProducts();
    Mono<Void> deleteProduct(Long id);

}
