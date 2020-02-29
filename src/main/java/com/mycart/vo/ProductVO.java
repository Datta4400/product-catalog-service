
package com.mycart.vo;

import java.util.Collection;
import java.util.stream.Collectors;

import com.mycart.domain.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductVO {

    private final String name;

    private final double price;

    private final String color;

    private final String sku;

    private final float size;
    
    private final String brand ;
    
    private final String category ;

    public static final ProductVO from(Product product) {
        return ProductVO.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .color(product.getColor())
                        .sku(product.getSku())
                        .size(product.getSize())
                        .brand(product.getBrandName())                        
                        .build();

    }

    public static final Collection<ProductVO> from(Collection<Product> products) {

        return products.stream()
                       .map(ProductVO::from)
                       .collect(Collectors.toList());

    }

}
