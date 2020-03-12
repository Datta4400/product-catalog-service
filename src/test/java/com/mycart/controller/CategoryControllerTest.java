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

import com.mycart.admin.controller.CategoryController;
import com.mycart.admin.service.CategoryService;
import com.mycart.exception.GlobalExceptionHandller;

@RunWith(SpringRunner.class)
@Import(GlobalExceptionHandller.class)

@WebMvcTest(value = CategoryController.class)

public class CategoryControllerTest {
	
	@MockBean
	private CategoryService categoryService; 
	
	public static Long TEST_CATEGORY_ID = 1L ;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void should_respond_ok_when_all_valid_input() throws  Exception {
		fail();
	}
	
	@Test
	public void should_respond_created_when_category_saved() throws Exception {
		fail();
		
	}
	
	@Test
	public void should_respond_bad_request_when_category_id_not_valid() throws Exception {
		fail();
	}
	
	@Test
	public void should_respond_bad_request_when_category_any_dto_input_is_not_valid() throws Exception{
		
	}
	
	@Test 
	public void should_respond_bad_request_when_category_does_not_exist() throws Exception {
		
	}
	
	@Test
	public void should_respond_no_content_when_category_is_deleted () throws Exception{
		
	}
}
