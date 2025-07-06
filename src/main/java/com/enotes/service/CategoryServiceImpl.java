package com.enotes.service;

import com.enotes.entity.Category;
import com.enotes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl  implements  CategorySevice{
    @Autowired
    private CategoryRepository categoryRepo;
    @Override
    public Boolean saveCategory(Category category) {
        category.setIsDeleted(false);
        category.setCreatedBy(1);
        category.setCreatedOn(new Date());
        Category saveCategory=categoryRepo.save(category);
        if(ObjectUtils.isEmpty(saveCategory)){
            return false;
        }
        return true;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category>categories =categoryRepo.findAll();
        return categories;
    }
}
