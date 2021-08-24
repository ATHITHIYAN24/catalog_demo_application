package com.catalog.catalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.catalog.model.Attribute;
import com.catalog.catalog.model.Category;
import com.catalog.catalog.model.Product;
import com.catalog.catalog.model.ProductAttribute;
import com.catalog.catalog.repo.AttributeProductRepository;
import com.catalog.catalog.repo.AttributeRepository;
import com.catalog.catalog.repo.CategoryRepository;
import com.catalog.catalog.repo.ProductRepository;
import com.catalog.catalog.wapper.ProductResponse;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AttributeProductRepository attributeProductRepository;

	@Autowired
	private AttributeRepository attributeRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional
	public String insertProduct(Product product) {
		if (product.getCategory() != null) {
			Optional<Category> category = categoryRepository.findById(product.getCategory().getCategoryId());
			if (category.isPresent()) {
				product.setCategory(category.get());
				productRepository.save(product);
				return "success";
			}
		}
		return "Failed";

	}

	public ProductResponse getProduct(Long productId) {
		Optional<Product> productOptional = productRepository.findById(productId);
		if (productOptional.isPresent()) {

			ProductResponse productResponse = new ProductResponse();
			List<Attribute> attributesResponse = attributeProductRepository
					.findByProduct(productOptional.get().getProductId());
			productResponse.setAttributes(attributesResponse);
			productResponse.setProductId(productId);
			productResponse.setCategory(productOptional.get().getCategory());
			return productResponse;
		} else {
			return null;
		}
	}

	public ProductResponse addAttributesToProduct(Long productId, List<Attribute> attributes) {
		List<Attribute> exsitingAttribute = new ArrayList<Attribute>();
		for (Attribute attribute : attributes) {
			Optional<Attribute> extingAttribute = attributeRepository.findById(attribute.getAttributeId());
			if (extingAttribute.isPresent()) {
				exsitingAttribute.add(extingAttribute.get());
			}
		}
		productRepository.findById(productId);
		Optional<Product> productOptional = productRepository.findById(productId);
		if (productOptional.isPresent()) {
			for (Attribute exstingAttribute : exsitingAttribute) {
			ProductAttribute productAttribute = attributeProductRepository.findByProductIdAndAttributeId(productId, exstingAttribute.getAttributeId());
				if(productAttribute==null){
				ProductAttribute productAbt = new ProductAttribute();
				productAbt.setAttribute(exstingAttribute);
				productAbt.setProduct(productOptional.get());
				attributeProductRepository.save(productAbt);
				}
			}

			ProductResponse productResponse = new ProductResponse();
			List<Attribute> attributesResponse = attributeProductRepository
					.findByProduct(productOptional.get().getProductId());
			productResponse.setAttributes(attributesResponse);
			productResponse.setProductId(productId);
			productResponse.setCategory(productOptional.get().getCategory());
			return productResponse;
		}

		return null;
	}
}