
package com.mycart.admin.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycart.admin.dto.BrandDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"products"})
@ToString(exclude = {"products"})
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

 @NotNull(message = "Name cannot be null")
	private String name;

	private String description;
	
	@Builder.Default
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "category_brand",
	joinColumns = @JoinColumn(name = "brandId"),
	inverseJoinColumns = @JoinColumn(name = "categoryId"))
	private Set<Category> categories = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "brandId")
	private Set<Product> products;

		
	public static Brand from(BrandDto dto) {
		return Brand.builder().name(dto.getName()).description(dto.getDescription()).build();
	}
}
