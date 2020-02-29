
package com.mycart.vo;

import java.util.Set;

import com.mycart.domain.Brand;
import com.mycart.domain.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandVO {

	private String name;

	private String description;

	Set<Product> products;

	public static BrandVO from(Brand brand) {
		return BrandVO.builder().name(brand.getName()).description(brand.getDescription()).products(brand.getProducts())
				.build();
	}

}
