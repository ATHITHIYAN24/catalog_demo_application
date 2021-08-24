package com.catalog.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.catalog.model.Category;
import com.catalog.catalog.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="category",method=RequestMethod.POST)
	public String addCatgory(@RequestBody Category category){
		return categoryService.insertCategory(category);
	}
	
	@RequestMapping(value="category/{categoryId}",method=RequestMethod.GET)
	public Category getCategory(@PathVariable("categoryId") Long categoryId){
		return categoryService.getCategory(categoryId);
	}
	
}
