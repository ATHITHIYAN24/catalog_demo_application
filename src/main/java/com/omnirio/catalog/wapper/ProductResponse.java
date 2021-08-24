package com.omnirio.catalog.wapper;



import java.util.List;

import com.omnirio.catalog.model.Category;

public class ProductResponse {
	
	private Long productId;
	
	private String productName;
	
	private Category category;
	
	private List<Attribute> attribute;
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Attribute> getAttribute() {
		return attribute;
	}

	public void setAttribute(List<Attribute> attribute) {
		this.attribute = attribute;
	}
	
	
	
}
