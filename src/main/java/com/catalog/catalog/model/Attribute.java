package com.catalog.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="attribute")
public class Attribute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="attribute_id")
	private Long attributeId;
	
	@Column(name="attribute_name")
	private String attributeName;
	

	public Long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}	
	
}
