package com.enotes.service;

import com.enotes.dto.CategoryDto;
import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;

import java.util.List;

public interface CategorySevice {

    public Boolean saveCategory(CategoryDto category);
    List<CategoryDto> getAllCategory();

    List<CategoryResponse> getActiveCategory();

}