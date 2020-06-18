package com.cos.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product{
	private int id;
	private String name;
	private type type;
	private int price;
	private int count; 
}
