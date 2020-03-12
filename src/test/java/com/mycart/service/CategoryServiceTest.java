package com.mycart.service;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mycart.admin.repository.BrandRepository;
import com.mycart.admin.repository.CategoryRepository;
import com.mycart.admin.service.CategoryService;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

	@Mock
	private CategoryRepository repository;

	@Mock
	private BrandRepository brandRepository;
	
	@InjectMocks
	private CategoryService categoryService ;
	
	@Test
	public void should_add_category_when_valid_input_given() throws Exception {
		fail();
	}
	
	@Test
	public void should_get_category_when_valid_input_given() throws Exception {
		fail();
	}
	
	@Test
	public void should_throw_product_service_exception_when_invalid_category_id_given() throws Exception {
		fail();
	}
	
	@Test
	public void should_throw_product_service_exception_when_invalid_parent_category_id_given() throws Exception {
		fail();
	}
	
	@Test
	public void should_throw_product_service_exception_when_given_category_id_does_not_exists() throws Exception {
		fail();
	}
	
	@Test
	public void should_throw_product_service_exception_when_given_parent_category_id_does_not_exist() throws Exception {
		fail();
	}
	

}
