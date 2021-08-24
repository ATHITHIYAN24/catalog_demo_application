package com.catalog.catalog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.catalog.model.Category;
import com.catalog.catalog.repo.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public String insertCategory(Category category){
		categoryRepository.save(category);
		return "success";
	}
	

	public Category getCategory(Long categoryId){
		Optional<Category> categoryOptional=categoryRepository.findById(categoryId);
		if(categoryOptional.isPresent()){
			return categoryOptional.get();
		}
		else{
			return null;
		}
	}
}
