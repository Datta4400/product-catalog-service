package com.mycart.common;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.mycart.domain.Brand;
import com.mycart.domain.Product;

import lombok.AllArgsConstructor;
import model.ProductSerachCrieteria;

@AllArgsConstructor
public class ProductSpecification implements Specification<Product> {

	private static final long serialVersionUID = 1L;

	private ProductSerachCrieteria criteria;

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		if (criteria.getOperation().equalsIgnoreCase(">")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.<String>get(criteria.getSearchType().name().toLowerCase()),
					criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase("<")) {
			return criteriaBuilder.lessThanOrEqualTo(root.<String>get(criteria.getSearchType().name().toLowerCase()),
					criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(":")) {
			if (root.get(criteria.getSearchType().name().toLowerCase()).getJavaType() == String.class) {

				return criteriaBuilder.like(root.<String>get(criteria.getSearchType().name().toLowerCase()),
						"%" + criteria.getValue() + "%");
			} else if (root.get(criteria.getSearchType().name().toLowerCase()).getJavaType() == Brand.class) {
				Join<Product, Brand> brandJoin = root.join("brand");
				return criteriaBuilder.like(brandJoin.<String>get("name"),
						"%" + criteria.getValue() + "%");

			} else {
				return criteriaBuilder.equal(root.get(criteria.getSearchType().name().toLowerCase()),
						criteria.getValue());
			}
		}
		return null;
	}

}
