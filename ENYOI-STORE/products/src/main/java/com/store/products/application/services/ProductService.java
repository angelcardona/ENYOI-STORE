package com.store.products.application.services;

import org.springframework.stereotype.Service;

import com.store.products.domain.models.Product;
import com.store.products.domain.ports.in.ProductUsesCases;
import com.store.products.domain.ports.out.IProductPersistencePort;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUsesCases {

    private final IProductPersistencePort persistencePort;
    @Override
    public Mono<Product> createProduct(Product product) {
        return persistencePort.save(product);
    }

    @Override
    public Mono<Product> getProductById(Long id) {
        return  persistencePort.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Product not found with id:" + id)));

    }

    @Override
    public Mono<Product> updateProduct(Long productId,Product product) {
        Mono<Product> existingProduct = persistencePort.findById(productId);
        return existingProduct.flatMap(productFound ->{
            productFound.setName(product.getName());
            productFound.setCategory(product.getCategory());
            productFound.setPrice(product.getPrice());
            productFound.setDescription(product.getDescription());

            return persistencePort.save(productFound);
        }).switchIfEmpty(existingProduct.flatMap(productNotFound -> {
            return Mono.error(new IllegalArgumentException("Product not found with id" + productId));
        }));
    }

    @Override
    public Flux<Product> getAllProducts() {
        return  persistencePort.findAll();
    }

    @Override
    public Mono<Void> deleteProduct(Long id) {
        return persistencePort.delete(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Product not found with id:" + id)));
    }

    

}
