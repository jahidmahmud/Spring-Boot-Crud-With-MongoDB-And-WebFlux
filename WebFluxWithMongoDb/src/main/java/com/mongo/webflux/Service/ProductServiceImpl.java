package com.mongo.webflux.Service;

import com.mongo.webflux.Dto.ProductDto;
import com.mongo.webflux.Repository.ProductRepository;
import com.mongo.webflux.Util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{
    Logger log= LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;


    public Flux<ProductDto> getAllProduct(){
        try {
            return productRepository
                    .findAll()
                    .map(AppUtil::productToProductDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Flux.just(new ProductDto());
    }

    public Mono<ProductDto> getProductById(int id){
        try {
            return productRepository
                    .findById(id)
                    .map(AppUtil::productToProductDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Mono.just(new ProductDto());
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDto){
        try {
            return productDto.map(AppUtil::productDtoToProduct)
                    .flatMap(productRepository::save)
                    .map(AppUtil::productToProductDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Mono.just(new ProductDto());
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDto){
        try {
            return productDto.map(AppUtil::productDtoToProduct)
                    .flatMap(productRepository::save)
                    .map(AppUtil::productToProductDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Mono.just(new ProductDto());
    }

    public Mono<Void> deleteProduct(int id){
        try {
            return productRepository.deleteById(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Mono.empty();
    }
}
