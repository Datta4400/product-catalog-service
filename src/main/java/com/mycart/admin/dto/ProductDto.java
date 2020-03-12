
package com.mycart.admin.dto;

import com.mycart.admin.entity.Brand;
import com.mycart.admin.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private String name;

    private double price;

    private String color;

    private float size;

    private String sku;
    
    private Long brandId ;
    
    private Long categoryId ;
        
}
