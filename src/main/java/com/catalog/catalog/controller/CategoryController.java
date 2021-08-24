package com.catalog.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.catalog.model.Category;
import com.catalog.catalog.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Category" , description="Operations Category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="category",method=RequestMethod.POST)
	@ApiOperation(value="Add Category", response=Category.class)
	public Category addCatgory(@RequestBody Category category){
		return categoryService.insertCategory(category);
	}
	
	@RequestMapping(value="category/{categoryId}",method=RequestMethod.GET)
	@ApiOperation(value="Get Category", response=Category.class)
	public Category getCategory(@PathVariable("categoryId") Long categoryId){
		return categoryService.getCategory(categoryId);
	}
	
}
