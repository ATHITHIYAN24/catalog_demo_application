package com.omnirio.catalog.wapper;

import java.util.List;

import com.omnirio.catalog.model.CategoryAttribute;

public class CategoryAttributeResponse {
	
	private Long catgoryId;
	
	private String catgoryName;
	
	private List<AttributeCategoryResponse> attributeCategoryResponse;

	public Long getCatgoryId() {
		return catgoryId;
	}

	public void setCatgoryId(Long catgoryId) {
		this.catgoryId = catgoryId;
	}

	public String getCatgoryName() {
		return catgoryName;
	}

	public void setCatgoryName(String catgoryName) {
		this.catgoryName = catgoryName;
	}

	public List<AttributeCategoryResponse> getAttributeCategoryResponse() {
		return attributeCategoryResponse;
	}

	public void setAttributeCategoryResponse(List<AttributeCategoryResponse> attributeCategoryResponse) {
		this.attributeCategoryResponse = attributeCategoryResponse;
	}

		
	
}
