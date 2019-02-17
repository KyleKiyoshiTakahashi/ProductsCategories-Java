package com.codingdojo.ProductsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.ProductsCategories.models.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();

	
}
