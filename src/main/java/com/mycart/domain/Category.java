
package com.mycart.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mycart.dto.CategoryDto;
import com.mycart.vo.CategoryVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String description;

	@Builder.Default
	@ManyToMany(mappedBy = "categories")
	private Set<Brand> brands = new HashSet<>();

	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();

	public static final Category from(CategoryDto dto) {
		return Category.builder().name(dto.getName()).description(dto.getDescription()).build();
	}

	public static final List<Category> from(List<CategoryDto> dtos) {
		return dtos.stream().map(Category::from).collect(Collectors.toList());
	}
	
	public static final CategoryVO from(Category category) {
		return CategoryVO.builder().name(category.getName()).description(category.getDescription()).build();
	}
	
}
