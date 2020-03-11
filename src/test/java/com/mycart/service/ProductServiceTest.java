package com.mycart.service;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mycart.repository.BrandRepository;
import com.mycart.repository.CategoryRepository;
import com.mycart.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@Mock
	private  ProductRepository repository;

	@Mock
	private  CategoryRepository categoryRepository;

	@Mock
	private  BrandRepository brandRepository ;
	
	@InjectMocks
	private ProductService productService ;
	
	@Test
	public void should_add_product_when_valid_input_given() throws Exception {
		fail();
		
	}
	
	@Test
	public void should_delete_product_when_valid_input_given() throws Exception {
		fail();
		
	}
	
	@Test
	public void should_get_product_when_valid_input_given() throws Exception {
		fail();
		
	}
	
	@Test
	public void should_throw_product_service_exception_when_invalid_product_id_given() throws Exception {
		fail();
		
	}
	
	@Test
	public void should_get_all_product_when_valid_input_given() throws Exception {
		fail();
		
	}
	
	@Test
	public void should_throw_product_service_exception_when_invalid_input_given() throws Exception {
		fail();
		
	}
	
	@Test
	public void should_throw_product_service_exception_when_given_brand_does_not_exists() throws Exception {
		fail();
		
	}
	
	@Test
	public void should_throw_product_service_exception_when_given_category_does_not_exists() throws Exception {
		fail();
		
	}
	
	
	
	

}
