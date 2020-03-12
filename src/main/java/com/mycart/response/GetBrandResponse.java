package com.mycart.response;

import com.mycart.admin.vo.BrandVO;
import com.mycart.common.BaseResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetBrandResponse extends BaseResponse<BrandVO>{
    
    public static final GetBrandResponse from(BrandVO brandVO) {
    	GetBrandResponse brandResponse = new GetBrandResponse();
        brandResponse.setData(brandVO);
        return brandResponse;
    }
    

}
