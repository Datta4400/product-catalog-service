package com.mycart.response;

import com.mycart.admin.vo.CategoryVO;
import com.mycart.common.BaseResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetCategoryResponse extends BaseResponse<CategoryVO>{
    
    public static final GetCategoryResponse from(CategoryVO categoryVO) {
        GetCategoryResponse categoryResponse = new GetCategoryResponse();
        categoryResponse.setData(categoryVO);
        return categoryResponse;
    }

}
