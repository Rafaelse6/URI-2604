package com.rafaelsantos.uri2604.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaelsantos.uri2604.entities.Product;
import com.rafaelsantos.uri2604.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query(nativeQuery = true, value = "SELECT id, name "
			+ "FROM products "
			+ "WHERE price < 10 OR price > 100")
	List<ProductMinProjection> sqlSearch(Double price);
}
