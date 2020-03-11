package com.mycart.response;

import com.mycart.common.BaseResponse;
import com.mycart.domain.Brand;
import com.mycart.vo.BrandVO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandResponse extends BaseResponse<BrandVO>{
    
    public static final BrandResponse from(BrandVO brandVO) {
        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setData(brandVO);
        return brandResponse;
    }
    

}
