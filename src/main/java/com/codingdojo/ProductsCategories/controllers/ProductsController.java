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
public class ProductsController {
	private final ProductService ps;
	private final CategoryService cs;
	
	public ProductsController(ProductService ps, CategoryService cs) {
		this.ps = ps;
		this.cs = cs;
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	@PostMapping("/products")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		} else {
			Product createdProduct =  ps.createProduct(product);
			return "redirect:/products/" + createdProduct.getId();
		}
	}
	@GetMapping("/products/{productId}")
	public String show(@ModelAttribute("product") Product prod, @PathVariable("productId") Long productId, Model model) {
		Product product = ps.findProduct(productId);
		model.addAttribute("allProducts", ps.findAllProducts());
		model.addAttribute("allCategories", cs.findAllCategories());
		model.addAttribute("product", product);
		return "/products/show.jsp";
	}
	@PostMapping("products/{productId}")
	public String addProduct(@PathVariable("productId") Long productId, @RequestParam("category") Long categoryId) {
		Product product = ps.findProduct(productId);
		Category category = cs.findCategory(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		ps.update(product);
		return "redirect:/products/"+ productId;
	}
	
	
	
	
}
