package com.cos.product.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.model.Product;
import com.cos.product.repository.ProductRepository;
import com.google.gson.Gson;

public class ProductAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		DB불러오기
		ProductRepository productRepository =
				ProductRepository.getInstance();
		
//		담고 
		List<Product> products = productRepository.findAll();
		
		request.setAttribute("products", products);
		
		RequestDispatcher dis = 
				request.getRequestDispatcher("home.jsp");
		
		dis.forward(request, response);
	
		
		
	} 
}
