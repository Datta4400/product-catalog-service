
package com.mycart.admin.vo;

import java.util.Set;
import java.util.stream.Collectors;

import com.mycart.admin.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {

    private  String name;

    private  double price;

    private  String color;

    private  String sku;

    private  float size;
    
    private String brand ;
    
    private  String category ;

    public static final ProductVO from(Product product) {
        return ProductVO.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .color(product.getColor())
                        .sku(product.getSku())
                        .size(product.getSize())
                        .brand(product.getBrand().getName())
                        .category(product.getCategory().getName())
                        .build();

    }

    public static final Set<ProductVO> from(Set<Product> products) {

        return products.stream()
                       .map(ProductVO::from)
                       .collect(Collectors.toSet());

    }

}
