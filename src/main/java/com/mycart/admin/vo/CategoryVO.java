
package com.mycart.admin.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.mycart.admin.entity.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryVO {

	private String name;

	private String description;

	@Builder.Default
	private Set<Category> subCategories = new HashSet<>();

	public static CategoryVO from(Category category) {
		
		
		return CategoryVO.builder()
				.name(category.getName())
				.description(category.getDescription())
				.subCategories(category.getChildren())
				.build();
	}

	public static Set<CategoryVO> from(Set<Category> categories) {
		return categories.stream().map(CategoryVO::from).collect(Collectors.toSet());
	}

}
