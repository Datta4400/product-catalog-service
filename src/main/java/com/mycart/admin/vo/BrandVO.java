
package com.mycart.admin.vo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.mycart.admin.entity.Brand;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandVO {

	private String name;

	private String description;
	
	
	@Builder.Default
	Set<CategoryVO> categories = new HashSet<>();

	public static BrandVO from(Brand brand) {
		return BrandVO.builder()
					.name(brand.getName())
					.description(brand.getDescription())
					.categories(CategoryVO.from(brand.getCategories()))
					.build();
	}
	
	public static Set<BrandVO> from(Set<Brand> brands) {
	    return brands.stream()
		    		 .map(BrandVO::from)
		    		 .collect(Collectors.toSet());

	}

}
