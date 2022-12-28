package com.mongo.webflux.Util;

import com.mongo.webflux.Dto.ProductDto;
import com.mongo.webflux.Models.Product;
import org.springframework.beans.BeanUtils;

public class AppUtil {

    public static ProductDto productToProductDto(Product product){
        ProductDto productDto=new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return productDto;
    }

    public static Product productDtoToProduct(ProductDto productDto){
        Product product=new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }
}
