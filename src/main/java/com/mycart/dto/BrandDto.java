package com.mycart.dto;

import com.mycart.dto.ProductDto.ProductDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandDto {

    private String name;
    private String description ;
}
