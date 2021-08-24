package com.omnirio.catalog.service;

import com.omnirio.catalog.model.Category;

public interface CategoryService {

	Category insertCategory(String categoryName);

	Category getCategory(Long categoryId);

}
