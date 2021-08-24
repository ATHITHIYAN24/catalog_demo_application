package com.catalog.catalog.service;

import com.catalog.catalog.model.Attribute;

public interface AttributeService {

	Attribute insertAttribute(Attribute attribute);

	Attribute getAttribute(Long attributeID);

}
