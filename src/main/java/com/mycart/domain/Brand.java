
package com.mycart.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mycart.dto.BrandDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long brandId;

	private String name;

	private String description;
	
	@OneToMany(targetEntity = Product.class, mappedBy = "brand", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;
	
	public static Brand from(BrandDto dto) {
		return Brand.builder().name(dto.getName()).description(dto.getDescription()).build();
	}
}
