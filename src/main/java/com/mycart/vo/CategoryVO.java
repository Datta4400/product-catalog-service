
package com.mycart.vo;

import java.util.Set;

import com.mycart.domain.Category;
import com.mycart.domain.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryVO {

	private String name;

	private String description;

	Set<Product> products;

	public static CategoryVO from(Category category) {
		return CategoryVO.builder().name(category.getName()).description(category.getDescription())
				.build();
	}

}
