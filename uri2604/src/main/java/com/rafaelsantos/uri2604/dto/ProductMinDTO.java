package com.rafaelsantos.uri2604.dto;

import com.rafaelsantos.uri2604.projections.ProductMinProjection;

public class ProductMinDTO {
	private Long id;
	private String name;

	private ProductMinDTO() {
	}

	public ProductMinDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ProductMinDTO(ProductMinProjection projection) {
		id = projection.getId();
		name = projection.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductMinDTO [id=" + id + ", name=" + name + "]";
	}
}