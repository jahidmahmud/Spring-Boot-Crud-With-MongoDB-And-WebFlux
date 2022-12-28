package com.mongo.webflux.Controller;

import com.mongo.webflux.Dto.ProductDto;
import com.mongo.webflux.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Product")
public class ProductController {
    Logger log= LoggerFactory.getLogger(ProductController.class);
    @Autowired
    ProductService service;

    @GetMapping("/")
    private Flux<ProductDto> getAllProduct(){
        try {
            return service.getAllProduct();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Flux.just(new ProductDto());
    }
    @GetMapping("/{id}")
    private Mono<ProductDto> getAllProduct(@PathVariable("id") int id){
        try {
            return service.getProductById(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Mono.just(new ProductDto());
    }
    @PostMapping("/")
    private Mono<ProductDto> addProduct(@RequestBody Mono<ProductDto> productDtoMono){
        try {
            return service.saveProduct(productDtoMono);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Mono.just(new ProductDto());
    }
    @PutMapping("/")
    private Mono<ProductDto> editProduct(@RequestBody Mono<ProductDto> productDtoMono){
        try {
            return service.updateProduct(productDtoMono);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Mono.just(new ProductDto());
    }
    @DeleteMapping("/{id}")
    private Mono<ResponseEntity> deleteProduct(@PathVariable("id") int id){
        try {
            service.deleteProduct(id);
            return Mono.just(ResponseEntity.ok().build());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Mono.just(ResponseEntity.notFound().build());
    }
}
