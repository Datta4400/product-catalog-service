
package com.mycart.vo;

import java.util.List;
import java.util.stream.Collectors;

import com.mycart.domain.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryVO {

	private String name;

	private String description;

	

	public static CategoryVO from(Category category) {
		return CategoryVO.builder().name(category.getName()).description(category.getDescription()).build();
	}

	public static List<CategoryVO> from(List<Category> categories) {
		return categories.stream().map(CategoryVO::from).collect(Collectors.toList());
	}

}
