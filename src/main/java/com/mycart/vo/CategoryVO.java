
package com.mycart.vo;

import java.util.List;

import com.mycart.domain.Category;
import com.mycart.domain.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryVO {

	private String name;

	private String description;

	List<ProductVO> products;

	public static CategoryVO from(Category category) {
		return CategoryVO.builder().name(category.getName()).description(category.getDescription())
				.build();
	}

}
