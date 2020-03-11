package com.mycart.controller;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mycart.exception.GlobalExceptionHandller;
import com.mycart.service.ProductService;

@RunWith(SpringRunner.class)
@Import(GlobalExceptionHandller.class)

@WebMvcTest(value = ProductController.class)

public class ProductControllerTest {
	
	@MockBean
	private ProductService productService; 
	
	public static Long TEST_PRODUCT_ID = 1L ;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void should_respond_ok_when_all_valid_input() throws  Exception {
		fail();
	}
	
	@Test
	public void should_respond_created_when_product_saved() throws Exception {
		fail();
		
	}
	
	@Test
	public void should_respond_bad_request_when_category_id_not_valid() throws Exception {
		fail();
	}
	
	@Test
	public void should_respond_bad_request_when_category_id_does_not_exists() throws Exception {
		fail();
	}
	
	@Test
	public void should_respond_bad_request_when_brand_id_does_not_exists() throws Exception {
		fail();
	}
	
	@Test
	public void should_respond_bad_request_when_product_any_dto_input_is_not_valid() throws Exception{
		
	}
	
	@Test 
	public void should_respond_bad_request_when_product_does_not_exist() throws Exception {
		
	}
	
	@Test
	public void should_respond_no_content_when_product_is_deleted () throws Exception{
		
	}



}
