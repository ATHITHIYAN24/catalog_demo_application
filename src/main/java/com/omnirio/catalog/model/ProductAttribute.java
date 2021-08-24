package com.omnirio.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_atrribute")
public class ProductAttribute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_atrribute_id")
	private Long productAtrributeId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", updatable = true)
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "category_attribute_id", referencedColumnName = "category_attribute_id", updatable = true)
	private CategoryAttribute categoryAttribute;
	
	@Column(name="attribute_value",nullable=false)
	private String attributeValue;

	public Long getProductAtrributeId() {
		return productAtrributeId;
	}

	public void setProductAtrributeId(Long productAtrributeId) {
		this.productAtrributeId = productAtrributeId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CategoryAttribute getCategoryAttribute() {
		return categoryAttribute;
	}

	public void setCategoryAttribute(CategoryAttribute categoryAttribute) {
		this.categoryAttribute = categoryAttribute;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	
	
}
