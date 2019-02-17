package com.codingdojo.ProductsCategories.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsCategories.models.Product;
import com.codingdojo.ProductsCategories.repositories.CategoryRepo;
import com.codingdojo.ProductsCategories.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo pr;
	private final CategoryRepo cr;
	
	public ProductService(ProductRepo pr, CategoryRepo cr) {
		this.pr = pr;
		this.cr = cr;
	}
	public Product createProduct(Product product) {
		return pr.save(product);
	}
	public Product findProduct(Long productId) {
		Optional<Product> optionalProduct = pr.findById(productId);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	public List<Product> findAllProducts(){
		return pr.findAll();
	}
	
	public void update(Product product) {
		pr.save(product);
	}
//	public List<Product> getAllExcept(Long categoryId) {
//		List<Product> products = this.findAllProducts();
//		List<Product> categoryProducts = cr.findCategory(categoryId).getProducts();
//		products.removeAll(categoryProducts);
//		return products;
//	}
	
	
	
}
