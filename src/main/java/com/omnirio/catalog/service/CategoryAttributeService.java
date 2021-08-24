package com.omnirio.catalog.service;

import com.omnirio.catalog.model.CategoryAttribute;
import com.omnirio.catalog.wapper.CategoryAttributeResponse;

public interface CategoryAttributeService {

	CategoryAttribute insertAttribute(String attributeName,Long categoryId);

	CategoryAttributeResponse getCategoryAttributeByCategoryId(Long categoryId);

}
