
package com.mycart.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private String name;

    private String description;
    
    @Builder.Default
    List<ProductDto> products = new ArrayList<>();
    
    
}
