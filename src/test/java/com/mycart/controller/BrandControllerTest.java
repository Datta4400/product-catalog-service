package com.mycart.controller;

import static com.mycart.utils.TestUtils.MAPPER;
import static com.mycart.utils.TestUtils.getBrandVO;
import static com.mycart.utils.TestUtils.getMockBrandDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.mycart.admin.controller.BrandController;
import com.mycart.admin.dto.BrandDto;
import com.mycart.admin.service.BrandService;
import com.mycart.admin.vo.BrandVO;
import com.mycart.exception.GlobalExceptionHandller;

import com.mycart.response.GetBrandResponse;

@RunWith(SpringRunner.class)
@Import(GlobalExceptionHandller.class)

@WebMvcTest(value = BrandController.class)
public class BrandControllerTest {

	@MockBean
	private BrandService brandService; 
	
	public static Long TEST_BRAND_ID = 1L ;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void should_resppond_created_when_brand_added_with_valid_input() throws Exception {
		final BrandDto brandDto = getMockBrandDto();
		
		final BrandVO brandVO = getBrandVO();
		when(this.brandService.addBrand(brandDto)).thenReturn(GetBrandResponse.from(brandVO));
		final MvcResult result = this.mockMvc
				.perform(post("/mycart/brand").accept(MediaType.APPLICATION_JSON_UTF8)
						.contentType(MediaType.APPLICATION_JSON_UTF8).content(MAPPER.writeValueAsBytes(brandDto)))
				.andExpect(status().isCreated()).andReturn();

		final GetBrandResponse actual = MAPPER.readValue(result.getResponse().getContentAsByteArray(),
				GetBrandResponse.class);

		assertThat(actual.getData().getName()).isNotNull();
		assertThat(actual.getData().getCategories()).isNotNull();

	}

	@Test
	public void should_respond_ok_when_brand_is_feched() throws Exception {

		
		final BrandVO brandVO = getBrandVO();
		when(this.brandService.getBrand(TEST_BRAND_ID)).thenReturn(GetBrandResponse.from(brandVO));
		final MvcResult result = this.mockMvc.perform(get("/mycart/brand/{id}", 1)).andExpect(status().isOk())
				.andExpect(jsonPath("$.data.name", is(equalTo(brandVO.getName())))).andReturn();

		final GetBrandResponse actual = MAPPER.readValue(result.getResponse().getContentAsByteArray(),
			GetBrandResponse.class);

		assertThat(actual.getData().getName()).isNotNull();
		assertThat(actual.getData().getCategories()).isNotNull();

	}
	
	@Test
	public void should_respond_ok_when_all_brands_feched() throws Exception{
		
	}
	
	@Test
	public void should_respond_no_content_when_brand_deleted_succss() throws Exception{
		fail();
	}
	@Test
	public void should_respond_bad_request_when_given_category_not_found() throws Exception{
		fail();
	}
	
	@Test
	public void should_respond_bad_request_when_given_brand_id_is_invalid() throws Exception{
		fail();
	}

}
