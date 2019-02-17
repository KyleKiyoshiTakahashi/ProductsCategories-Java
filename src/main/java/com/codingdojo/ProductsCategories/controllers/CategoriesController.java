package com.codingdojo.ProductsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ProductsCategories.models.Category;
import com.codingdojo.ProductsCategories.models.Product;
import com.codingdojo.ProductsCategories.services.CategoryService;
import com.codingdojo.ProductsCategories.services.ProductService;

@Controller
public class CategoriesController {
	private final CategoryService cs;
	private final ProductService ps;
	
	public CategoriesController(CategoryService cs, ProductService ps) {
		this.cs = cs;
		this.ps = ps;
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	@PostMapping("/categories")
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			Category createdCategory =  cs.createCategory(category);
			return "redirect:/categories/" + createdCategory.getId();
		}
	}
	@GetMapping("/categories/{categoryId}")
	public String show(@ModelAttribute("category") Category cat, @PathVariable("categoryId")Long categoryId, Model model) {
		Category category = cs.findCategory(categoryId);
		model.addAttribute("allCategories", cs.findAllCategories());
		model.addAttribute("allProducts", ps.findAllProducts());
		model.addAttribute("category", category);
		return "/categories/show.jsp";
	}
	@PostMapping("/categories/{id}")
	public String addProduct(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
		Category category = cs.findCategory(categoryId);
		Product product = ps.findProduct(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		cs.update(category);
		return "redirect:/categories/" + categoryId;
	}
}
