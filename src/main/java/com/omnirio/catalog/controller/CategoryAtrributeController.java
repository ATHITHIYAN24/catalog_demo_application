package com.omnirio.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.catalog.model.CategoryAttribute;
import com.omnirio.catalog.service.CategoryAttributeService;
import com.omnirio.catalog.wapper.CategoryAttributeResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// This controller having two api for insert and get attributes
@RestController
@Api(value="Attribute" , description="Operation Attribute")
public class CategoryAtrributeController {
	
	@Autowired
	private CategoryAttributeService categoryAttributeService;
	
	@RequestMapping(value="category/attribute",method=RequestMethod.POST)
	@ApiOperation(value="Add Category Attribute", response=CategoryAttribute.class)
	public CategoryAttribute addAttribute(@RequestParam(value="attributeName",required=true) String attributeName,@RequestParam(value="categoryId",required=true) Long categoryId){
		return categoryAttributeService.insertAttribute(attributeName,categoryId);
	}
	
	@RequestMapping(value="category/attribute",method=RequestMethod.GET)
	public CategoryAttributeResponse getCategoryAttribute(@RequestParam(value="categoryId",required=true) Long categoryId){
		return categoryAttributeService.getCategoryAttributeByCategoryId(categoryId);
	}
	
	
}
