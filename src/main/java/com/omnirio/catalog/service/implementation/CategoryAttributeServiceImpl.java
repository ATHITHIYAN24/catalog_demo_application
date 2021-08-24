package com.omnirio.catalog.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.model.CategoryAttribute;
import com.omnirio.catalog.repo.CategoryAttributeRepository;
import com.omnirio.catalog.repo.CategoryRepository;
import com.omnirio.catalog.service.CategoryAttributeService;
import com.omnirio.catalog.wapper.AttributeCategoryResponse;
import com.omnirio.catalog.wapper.CategoryAttributeResponse;

@Service
public class CategoryAttributeServiceImpl implements CategoryAttributeService {
	
	@Autowired
	private CategoryAttributeRepository categoryAttributeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryAttribute insertAttribute(String attributeName,Long categoryId){
		CategoryAttribute categoryAttribute=new CategoryAttribute();
		Optional<Category> category=categoryRepository.findById(categoryId);
		if(category.isPresent()){
		categoryAttribute.setCategory(category.get());
		categoryAttribute.setAttributeName(attributeName);
		categoryAttribute=categoryAttributeRepository.save(categoryAttribute);
		return categoryAttribute;
		}
		return null;
	}
	
	public CategoryAttributeResponse getCategoryAttributeByCategoryId(Long categoryId){
		Optional<Category> category=categoryRepository.findById(categoryId);
		if(category.isPresent()){
			CategoryAttributeResponse categoryAttributeResponse = new CategoryAttributeResponse();
			categoryAttributeResponse.setCatgoryId(category.get().getCategoryId());
			categoryAttributeResponse.setCatgoryName(category.get().getCategoryName());
			List<CategoryAttribute> categoryAttributes = categoryAttributeRepository.findByCategory(category.get());
		    List<AttributeCategoryResponse> attributeCategoryResponses = new ArrayList<AttributeCategoryResponse>(); 
			if(categoryAttributes!=null){
			for(CategoryAttribute categoryAttribute:categoryAttributes){
				AttributeCategoryResponse attributeCategoryResponse = new AttributeCategoryResponse();
				attributeCategoryResponse.setAttributeName(categoryAttribute.getAttributeName());
				attributeCategoryResponse.setCategoryAttributeId(categoryAttribute.getCategoryAttributeId());
				attributeCategoryResponses.add(attributeCategoryResponse);
			}
		    }
			categoryAttributeResponse.setAttributeCategoryResponse(attributeCategoryResponses);
			return categoryAttributeResponse;
		}
		return null;
	}
	
	
	
}
