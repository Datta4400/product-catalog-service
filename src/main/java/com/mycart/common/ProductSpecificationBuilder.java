package com.mycart.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import com.mycart.domain.Product;

import lombok.AllArgsConstructor;
import model.ProductSerachCrieteria;

@AllArgsConstructor
public class ProductSpecificationBuilder {

	private  List<ProductSerachCrieteria> params;

	public ProductSpecificationBuilder() {
        this.params = new ArrayList<ProductSerachCrieteria>();
    }
	public ProductSpecificationBuilder as(SearchType key, String operation, Object value) {
		this.params.add(new ProductSerachCrieteria(key, operation, value));
		return this;
	}

	public Specification<Product> build() {

		List<Specification<Product>> specs = params.stream().map(ProductSpecification::new).collect(Collectors.toList());

		Specification<Product> result = specs.get(0);

		
		
		for (int i = 1; i < params.size(); i++) {
			result = params.get(i).isOrPredicate() ? Specification.where(result).or(specs.get(i))
					: Specification.where(result).and(specs.get(i));
		}
		return result;

	}

}
