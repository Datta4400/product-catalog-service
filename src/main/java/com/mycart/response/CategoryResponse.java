package com.mycart.response;

import com.mycart.admin.entity.Category;
import com.mycart.admin.vo.CategoryVO;
import com.mycart.common.BaseResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryResponse extends BaseResponse<CategoryVO>{
    
    public static final CategoryResponse from(CategoryVO categoryVO) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setData(categoryVO);
        return categoryResponse;
    }

}
