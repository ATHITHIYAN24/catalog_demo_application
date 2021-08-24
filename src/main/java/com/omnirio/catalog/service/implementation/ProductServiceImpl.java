package com.omnirio.catalog.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.model.CategoryAttribute;
import com.omnirio.catalog.model.Product;
import com.omnirio.catalog.model.ProductAttribute;
import com.omnirio.catalog.repo.AttributeProductRepository;
import com.omnirio.catalog.repo.CategoryAttributeRepository;
import com.omnirio.catalog.repo.CategoryRepository;
import com.omnirio.catalog.repo.ProductRepository;
import com.omnirio.catalog.service.ProductService;
import com.omnirio.catalog.wapper.Attribute;
import com.omnirio.catalog.wapper.ProductRequest;
import com.omnirio.catalog.wapper.ProductResponse;
import com.omnirio.catalog.wapper.ProdutAttributeRequest;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AttributeProductRepository attributeProductRepository;

	@Autowired
	private CategoryAttributeRepository categoryAttributeRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional
	public ProductResponse insertProduct(ProductRequest productRequest) {
		Optional<Category> category = categoryRepository.findById(productRequest.getCategoryId());
		if (category.isPresent()) {
			Product product = new Product();
			product.setName(productRequest.getProductName());
			product.setCategory(category.get());
			product = productRepository.save(product);
			if (productRequest.getProdutAttributes() != null) {
				for (ProdutAttributeRequest produtAttributeRequest : productRequest.getProdutAttributes()) {
					ProductAttribute productAttribute = new ProductAttribute();
					Optional<CategoryAttribute> categoryAttribute = categoryAttributeRepository
							.findById(produtAttributeRequest.getCategoryAttributeId());
					if (categoryAttribute.isPresent()) {
						productAttribute.setCategoryAttribute(categoryAttribute.get());
						productAttribute.setAttributeValue(produtAttributeRequest.getAttributeValue());
						productAttribute.setProduct(product);
						attributeProductRepository.save(productAttribute);
					}
				}
			}

			ProductResponse productResponse = new ProductResponse();
			productResponse.setCategory(category.get());
			productResponse.setProductId(product.getProductId());
			productResponse.setProductName(product.getName());
			List<Attribute> attributes = new ArrayList<Attribute>();
			List<ProductAttribute> productAttributes = attributeProductRepository
					.findByProductId(product.getProductId());
			if (productAttributes != null) {
				for (ProductAttribute productAttribute : productAttributes) {
					Attribute attribute = new Attribute();
					attribute.setAttributeName(productAttribute.getCategoryAttribute().getAttributeName());
					attribute.setAttributeValue(productAttribute.getAttributeValue());
					attribute.setAttributeId(productAttribute.getProductAtrributeId());
					attributes.add(attribute);
				}
			}
			productResponse.setAttribute(attributes);
			return productResponse;
		}
		return null;
	}

	public ProductResponse getProduct(Long productId) {
		Optional<Product> productOptional = productRepository.findById(productId);
		if (productOptional.isPresent()) {
			ProductResponse productResponse = new ProductResponse();
			productResponse.setCategory(productOptional.get().getCategory());
			productResponse.setProductId(productOptional.get().getProductId());
			productResponse.setProductName(productOptional.get().getName());
			List<Attribute> attributes = new ArrayList<Attribute>();
			List<ProductAttribute> productAttributes = attributeProductRepository
					.findByProductId(productOptional.get().getProductId());
			if (productAttributes != null) {
				for (ProductAttribute productAttribute : productAttributes) {
					Attribute attribute = new Attribute();
					attribute.setAttributeName(productAttribute.getCategoryAttribute().getAttributeName());
					attribute.setAttributeValue(productAttribute.getAttributeValue());
					attribute.setAttributeId(productAttribute.getProductAtrributeId());
					attributes.add(attribute);
				}
			}
			productResponse.setAttribute(attributes);
			return productResponse;
		} else {
			return null;
		}
	}
}