
package com.mycart.admin.vo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mycart.admin.entity.Category;
import com.mycart.admin.entity.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryVO {

	private String name;
	
	@JsonInclude(Include.NON_NULL)
	private String description;

	@Builder.Default
	@JsonInclude(Include.NON_NULL)
	private Set<CategoryVO> subCategories = new HashSet<>();
	
	@Builder.Default
	@JsonInclude(Include.NON_NULL)
	private Set<ProductVO> products = new HashSet<>();

	public static CategoryVO from(Category category) {
		
		return CategoryVO.builder()
				.name(category.getName())
				.description(category.getDescription())
				.subCategories(CategoryVO.from(category.getChildren()))
				.products(ProductVO.from(category.getProducts()))
				.build();
	}

	public static Set<CategoryVO> from(Set<Category> categories) {
	    if(null != categories)
		return categories.stream()
				 .map(CategoryVO::from)
				 .collect(Collectors.toSet());
	    return null ;
	}

}
