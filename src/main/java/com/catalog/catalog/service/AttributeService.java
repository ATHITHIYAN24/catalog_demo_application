package com.catalog.catalog.service;

import com.catalog.catalog.model.Attribute;

public interface AttributeService {

	String insertAttribute(Attribute attribute);

	Attribute getAttribute(Long attributeID);

}
