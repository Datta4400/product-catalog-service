
package com.mycart.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycart.dto.CategoryDto;
import com.mycart.vo.CategoryVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"parent","children","brands","products"})
@ToString(exclude = {"parent","children","brands","products"})
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String description;

	@ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId")
	private Category parent;

	@JsonIgnore
	@OneToMany(targetEntity = Category.class, cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.LAZY)
	private Set<Category> children;

	/*
	 * @Builder.Default
	 * 
	 * @ManyToMany(mappedBy = "categories") private Set<Brand> brands = new
	 * HashSet<>();
	 */
	@JsonIgnore
	@Builder.Default
	@ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
	private Set<Brand> brands = new HashSet<>();

	@Builder.Default
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	private Set<Product> products = new HashSet<>();
	

	public static final Category from(CategoryDto dto) {
		return Category.builder().name(dto.getName()).description(dto.getDescription()).build();
	}

	public static final Set<Category> from(Set<CategoryDto> dtos) {
		return dtos.stream().map(Category::from).collect(Collectors.toSet());
	}

	public static final CategoryVO from(Category category) {
		return CategoryVO.builder().name(category.getName()).description(category.getDescription()).build();
	}

}
