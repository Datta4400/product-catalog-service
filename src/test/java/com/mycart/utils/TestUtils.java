package com.mycart.utils;
import java.util.HashSet;

import org.assertj.core.util.Sets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycart.admin.dto.BrandDto;
import com.mycart.admin.vo.BrandVO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {

	public static final ObjectMapper MAPPER = new ObjectMapper () ;
	public static BrandDto getMockBrandDto() {
		return BrandDto.builder().name("Test Brand").description("Description").categories(new HashSet<>(1)).build();
	}
	public static BrandVO getBrandVO() {
		
			return BrandVO.builder().name("Test Brand").description("Description").categories(Sets.newHashSet()).build();
		
	}
}
