
package com.mycart.vo;

import java.util.ArrayList;
import java.util.List;

import com.mycart.domain.Brand;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandVO {

	private String name;

	private String description;
	
	@Builder.Default
	private List<CategoryVO> categories = new ArrayList<CategoryVO>();

	public static BrandVO from(Brand brand) {
		return BrandVO.builder().name(brand.getName()).description(brand.getDescription()).categories(CategoryVO.from(brand.getCategories()))
				.build();
	}

}
