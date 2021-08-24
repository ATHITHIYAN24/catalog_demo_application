package com.catalog.catalog.wapper;

import java.util.List;

import com.catalog.catalog.model.Attribute;
import com.catalog.catalog.model.Category;

public class ProductResponse {
	
	private Long productId;
	
	private Category category;
	
	private List<Attribute> attributes;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	
	
}
