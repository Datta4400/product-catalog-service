
package com.mycart.dto;

import com.mycart.domain.Brand;
import com.mycart.domain.Category;

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
        
}
