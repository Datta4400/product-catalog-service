package com.mycart.service;

import static  com.mycart.common.SearchType.valueOf;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mycart.common.ProductSpecificationBuilder;
import com.mycart.domain.Product;
import com.mycart.repository.ProductRepository;

import model.SearchResult;


@Service
public class ProductSearchService extends SearchResult<Product> {

	@Autowired
	private ProductRepository repositry;

	public List<Product> getProductByCrieteria(final String crieteria) {

		ProductSpecificationBuilder builder = new ProductSpecificationBuilder();
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
		Matcher matcher = pattern.matcher(crieteria + ",");

		while (matcher.find()) {
			builder.as(valueOf(matcher.group(1).toUpperCase()), matcher.group(2), matcher.group(3));
		}
		Specification<Product> spec = builder.build();

		List<Product> products = repositry.findAll(spec);
		return products;

	}

}
