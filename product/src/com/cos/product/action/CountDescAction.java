package com.cos.product.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.model.Product;
import com.cos.product.repository.ProductRepository;
import com.google.gson.Gson;

public class CountDescAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		
		ProductRepository productRepository = ProductRepository.getInstance();
		
		List<Product> products = productRepository.count();
		
		String productsJson = gson.toJson(products);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/Json; charser = utf-8");
		
		PrintWriter pw = response.getWriter();
		
		pw.println(productsJson);
		

	}
}
