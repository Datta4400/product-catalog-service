
package com.mycart.response;

import java.util.Collection;
import java.util.stream.Collectors;

import com.mycart.admin.entity.Product;
import com.mycart.admin.vo.ProductVO;
import com.mycart.common.BaseResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAllProductResponse extends BaseResponse<Collection<ProductVO>> {

	public static final GetAllProductResponse from(Collection<ProductVO> productVOs) {
		GetAllProductResponse productResponse = new GetAllProductResponse();
		productResponse.setData(productVOs);
		return productResponse;
	}

}
