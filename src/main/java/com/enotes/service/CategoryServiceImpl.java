package com.enotes.service;

import com.enotes.dto.CategoryDto;
import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;
import com.enotes.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl  implements  CategorySevice{
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public Boolean saveCategory(CategoryDto categoryDto) {

       /* category.setIsDeleted(false);
        category.setCreatedBy(1);
        category.setCreatedOn(new Date());
        Category saveCategory=categoryRepo.save(category);
        */
        Category category =mapper.map(categoryDto,Category.class);

        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setIsActive(categoryDto.getIsActive());
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
    public List<CategoryDto> getAllCategory() {
       // List<Category>categories =categoryRepo.findAll();
        List<Category>categories =categoryRepo.findByIsDeletedFalse();
       List<CategoryDto> categoryDtoList= categories.stream().
                map(cat->mapper.map(cat,CategoryDto.class))
                .toList();
        return categoryDtoList;
    }

    @Override
    public List<CategoryResponse> getActiveCategory() {
        List<Category> categories=categoryRepo.findByIsActiveTrueAndIsDeletedFalse();
        List<CategoryResponse> CategoryResponseList = categories.stream()
                .map(cat->mapper.map(cat, CategoryResponse.class)).toList();

        return CategoryResponseList;
    }

    @Override
    public CategoryDto categoryById(Integer id) {
        Optional<Category> findCategoryById = categoryRepo.findByIdAndIsDeletedFalse(id);
        if (findCategoryById.isPresent()) {
            Category category = findCategoryById.get();
            return mapper.map(category, CategoryDto.class);
        }
        return null;
    }

    @Override
    public Boolean deleteCategory(Integer Id) {
        Optional<Category> findCategoryById = categoryRepo.findById(Id);
        if(findCategoryById.isPresent()){
            Category category = findCategoryById.get();
            category.setIsDeleted(true);
            categoryRepo.save(category);
            return true;
        }
        return false;
    }
}
