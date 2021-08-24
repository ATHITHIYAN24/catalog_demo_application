package com.omnirio.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//This controller having two api for insert and get category
@RestController
@Api(value="Category" , description="Operations Category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="category",method=RequestMethod.POST)
	@ApiOperation(value="Add Category", response=Category.class)
	public Category addCatgory(@RequestParam(name="categoryName",required=true) String categoryName){
		return categoryService.insertCategory(categoryName);
	}
	
}
