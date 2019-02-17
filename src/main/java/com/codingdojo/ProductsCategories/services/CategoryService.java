package com.codingdojo.ProductsCategories.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.codingdojo.ProductsCategories.models.Category;

import com.codingdojo.ProductsCategories.repositories.CategoryRepo;
import com.codingdojo.ProductsCategories.repositories.ProductRepo;

@Service
public class CategoryService {
	private final CategoryRepo cr;
	private final ProductRepo pr;
	
	public CategoryService(CategoryRepo cr, ProductRepo pr) {
		this.cr = cr;
		this.pr = pr;
	}
	public Category createCategory(Category category) {
		return cr.save(category);
	}
	public Category findCategory(Long categoryId) {
		Optional<Category> optionalCat = cr.findById(categoryId);
		if(optionalCat.isPresent()) {
			return optionalCat.get();
		} else {
			return null;
		}
	}
	public List<Category> findAllCategories(){
		return cr.findAll();
	}
	
	
	public void update(Category category) {
		cr.save(category);
	}
//	public List<Category> getAllExcept(Long productId) {
//		List<Category> categories = this.findAllCategories();
//		List<Category> productCategories = pr.findProduct(productId).getCategories();
//		categories.removeAll(productCategories);
//		return categories;
//	}
}
