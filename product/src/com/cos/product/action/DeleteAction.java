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

public class DeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("DeleteAction : id" + id );
		
		ProductRepository productRepository =
				ProductRepository.getInstance();
		
		int result = productRepository.remove(id);
		
		if (result == 1) {
			Gson gson = new Gson();
			
			List<Product> products = productRepository.findAll();
			
			String productsJson = gson.toJson(products);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/Json; charser = utf-8");
			
			PrintWriter pw = response.getWriter();
			
			pw.println(productsJson);
			
				
		}
	
		

	}
}
