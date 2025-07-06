package com.enotes.repository;

import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByIsActive(Boolean isActive);

}
