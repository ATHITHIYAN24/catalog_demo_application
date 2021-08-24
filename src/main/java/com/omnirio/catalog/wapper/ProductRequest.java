package com.omnirio.catalog.wapper;

import java.util.List;

public class ProductRequest {
	
	private String productName;
	
	private Long categoryId;
	
	private List<ProdutAttributeRequest> produtAttributes;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public List<ProdutAttributeRequest> getProdutAttributes() {
		return produtAttributes;
	}

	public void setProdutAttributes(List<ProdutAttributeRequest> produtAttributes) {
		this.produtAttributes = produtAttributes;
	}
	
	
	
}
