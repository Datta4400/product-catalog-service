
package com.mycart.response;

import java.util.Collection;
import java.util.stream.Collectors;

import com.mycart.common.BaseResponse;
import com.mycart.domain.Product;
import com.mycart.vo.ProductVO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponse extends BaseResponse<Collection<ProductVO>> {

	
 	public static final ProductResponse from(Collection<Product> products) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setData(products.stream().map(ProductVO::from).collect(Collectors.toList()));
		return productResponse;
	}

}
