package com.codingdojo.ProductsCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.ProductsCategories.models.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{
	List<Category> findAll();

	void save(Optional<Category> category);





	

	
}
