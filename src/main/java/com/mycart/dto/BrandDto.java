package com.mycart.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandDto {

	private String name;
	private String description;
	
	@Builder.Default
	Set<Long> categories = new HashSet<>();
}
