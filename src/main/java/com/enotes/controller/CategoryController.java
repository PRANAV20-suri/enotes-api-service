package com.enotes.controller;

import com.enotes.dto.CategoryDto;
import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;
import com.enotes.service.CategorySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
@RestController
@RequestMapping("/apiv1/category") // no trailing slash
public class CategoryController {

    @Autowired
    CategorySevice categorySevice;

    @PostMapping("/save-category")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto category) {
        Boolean saveCategory = categorySevice.saveCategory(category);
        if (saveCategory) {
            return new ResponseEntity<>("Category saved successfully.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save category.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory() {
        List<CategoryDto> allCategory = categorySevice.getAllCategory();
        if (CollectionUtils.isEmpty(allCategory)) {
            return new ResponseEntity<>("No categories found.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(allCategory, HttpStatus.OK);
        }
    }
    @GetMapping
    public String checkcontroller(){
        return "Controller running good";
    }
    @GetMapping("/active-category")
    public ResponseEntity<?> getActiveCategory() {
        List<CategoryResponse> allCategory = categorySevice.getActiveCategory();
        if (CollectionUtils.isEmpty(allCategory)) {
            return new ResponseEntity<>("No categories found.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(allCategory, HttpStatus.OK);
        }
    }


}
