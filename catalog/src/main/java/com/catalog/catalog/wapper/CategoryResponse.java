package com.catalog.catalog.wapper;

import java.util.List;


import com.catalog.catalog.model.Product;

public class CategoryResponse {
	
	private Long catgoryId;
	
	private String catgoryName;
	
	private List<Product> productList;

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

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
}
