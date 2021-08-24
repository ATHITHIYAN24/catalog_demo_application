package com.catalog.catalog.service;

import com.catalog.catalog.model.Category;

public interface CategoryService {

	String insertCategory(Category category);

	Category getCategory(Long categoryId);

}
