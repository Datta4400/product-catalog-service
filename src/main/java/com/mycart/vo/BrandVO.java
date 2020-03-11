
package com.mycart.vo;

import java.util.HashSet;
import java.util.Set;

import com.mycart.domain.Brand;
import com.mycart.domain.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandVO {

	private String name;

	private String description;
	
	@Builder.Default
	Set<Category> categories = new HashSet<>();

	public static BrandVO from(Brand brand) {
		return BrandVO.builder().name(brand.getName()).description(brand.getDescription()).categories(brand.getCategories())
				.build();
	}

}
