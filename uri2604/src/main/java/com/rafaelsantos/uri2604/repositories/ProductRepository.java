package com.rafaelsantos.uri2604.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaelsantos.uri2604.dto.ProductMinDTO;
import com.rafaelsantos.uri2604.entities.Product;
import com.rafaelsantos.uri2604.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value = "SELECT id, name " + "FROM products " + "WHERE price < 10 OR price > 100")
	List<ProductMinProjection> sqlSearch(Double price);

	@Query("SELECT new com.rafaelsantos.uri2604.dto.ProductMinDTO(obj.id, obj.name)" 
			+ "FROM Product obj "
			+ "WHERE obj.price < 10 OR obj.price > 100")
	List<ProductMinDTO> jpqlSearch(Double price);
}
