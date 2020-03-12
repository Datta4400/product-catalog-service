package com.mycart.service;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycart.admin.repository.BrandRepository;
import com.mycart.admin.repository.CategoryRepository;
import com.mycart.admin.service.BrandService;

@RunWith(MockitoJUnitRunner.class)
public class BrandServiceTest {
	
	@Mock
	BrandRepository repository;
	
	@Mock
	CategoryRepository categoryRepositiry ;
	
	@InjectMocks
	BrandService brandService ;
	
	@Test
	public void should_get_brands_if_valid_input_give() throws Exception {
		fail();
	}

	@Test
	void should_throw_product_service_exception_when_category_id_does_not_exists() throws Exception {
		fail();
	}
	
	@Test
	void should_throw_product_service_exception_when_brand_not_found() throws Exception {
		fail();
	}
	
	@Test
	void should_add_brand_when_valid_input_given() throws Exception {
		fail();
	}
	
	@Test
	void should_delete_brand_when_valid_input_given() throws Exception{
		fail();
	}
	
	
	

}
