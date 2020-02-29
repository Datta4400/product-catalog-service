package com.mycart.response;

import com.mycart.common.BaseResponse;
import com.mycart.domain.Category;
import com.mycart.vo.CategoryVO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryResponse extends BaseResponse<CategoryVO>{
    
    public static final CategoryResponse from(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setData(CategoryVO.from(category));
        return categoryResponse;
    }

}
