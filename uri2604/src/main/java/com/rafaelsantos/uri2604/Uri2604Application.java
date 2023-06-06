package com.rafaelsantos.uri2604;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelsantos.uri2604.dto.ProductMinDTO;
import com.rafaelsantos.uri2604.projections.ProductMinProjection;
import com.rafaelsantos.uri2604.repositories.ProductRepository;

@SpringBootApplication
public class Uri2604Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2604Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("---SQL RESULT---");
		List<ProductMinProjection> list = repository.sqlSearch(0.0);
		List<ProductMinDTO> sqlResult = list.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());
		
		for(ProductMinDTO obj : sqlResult) {
			System.out.println(obj);
		}
		
		System.out.println("\n\n");

		System.out.println("---JPQL RESULT---");
		
		List<ProductMinDTO> jpqlResult = repository.jpqlSearch(560.0);
		for (ProductMinDTO obj: jpqlResult) {
			System.out.println(obj);
		}
	}
}
