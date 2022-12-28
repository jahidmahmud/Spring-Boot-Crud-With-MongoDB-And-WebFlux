package com.mongo.webflux.Service;

import com.mongo.webflux.Dto.ProductDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductDto> getAllProduct();
    Mono<ProductDto> getProductById(int id);
    Mono<ProductDto> saveProduct(Mono<ProductDto> productDto);
    Mono<ProductDto> updateProduct(Mono<ProductDto> productDto);
    Mono<Void> deleteProduct(int id);
}
