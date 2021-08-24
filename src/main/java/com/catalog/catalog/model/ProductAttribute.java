package com.catalog.catalog.model;

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
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", updatable = true)
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id", updatable = true)
	private Attribute attribute;
	
	@Column(name="attribute_value")
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

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	
	
}
