
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
public class CategoryDto {

	private String name;

	private String description;
	
	@Builder.Default
	private Long parentId = 0L;

	@Builder.Default
	private Set<Long> brandIds = new HashSet<>();


}
