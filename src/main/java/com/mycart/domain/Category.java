
package com.mycart.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mycart.dto.CategoryDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private long id;
   
    private  String name;
    
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products ;
    
    
    public static final Category from(CategoryDto dto) {
        return Category.builder()
                       .name(dto.getName())
                       .description(dto.getDescription())
                       .build();
    }
}
