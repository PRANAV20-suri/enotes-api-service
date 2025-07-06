package com.enotes.service;

import com.enotes.entity.Category;

import java.util.List;

public interface CategorySevice {

    public Boolean saveCategory(Category category);
    List<Category> getAllCategory();

}