package com.rds.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rds.cursomc.domain.Category;
import com.rds.cursomc.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Transactional(readOnly = true)
	Page<Product> findDistintByNameContainingAndCategoriesIn(String name, List<Category> categories, Pageable pageRequest);

}
