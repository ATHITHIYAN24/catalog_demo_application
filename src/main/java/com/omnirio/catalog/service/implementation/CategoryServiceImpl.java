package com.omnirio.catalog.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.repo.CategoryRepository;
import com.omnirio.catalog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category insertCategory(String categoryName) {
		Category category=new Category();
		category.setCategoryName(categoryName);
		category = categoryRepository.save(category);
		return category;
	}

	public Category getCategory(Long categoryId) {
		Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
		if (categoryOptional.isPresent()) {
			return categoryOptional.get();
		} else {
			return null;
		}
	}
}
