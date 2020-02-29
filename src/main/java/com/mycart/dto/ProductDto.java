
package com.mycart.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    private String categoryName;

    private String brandName;

    @JsonIgnore
    private long brandId;

    @JsonIgnore
    private long categoryId;

}
