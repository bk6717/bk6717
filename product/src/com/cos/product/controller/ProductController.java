package com.cos.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.action.Action;
import com.cos.product.action.CountDescAction;
import com.cos.product.action.DeleteAction;
import com.cos.product.action.GofirstAction;
import com.cos.product.action.PriceDescAction;
import com.cos.product.action.ProductAction;


@WebServlet("/test")
public class ProductController extends HttpServlet{
	private static final String TAG = "ProductController";
	private static final long serialVersionUID = 1L;
	
	    public ProductController() {
		   super();
	   }

     	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request, response);
		}
		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// http://localhost:8000/blog/user?cmd=join
			String cmd = request.getParameter("cmd");
			System.out.println(TAG + " router : " + cmd);
			Action action = router(cmd);
			action.execute(request, response);
		}
		
		public Action router(String cmd) {			
			if(cmd.equals("product")) {
				return new ProductAction();
			}else if(cmd.equals("priceDesc")) {
				return new PriceDescAction();
			}else if(cmd.equals("goFirst")) {
				return new GofirstAction();
			}else if(cmd.equals("countDesc")) {
				return new CountDescAction();
			}else if(cmd.equals("remove")) {
				return new DeleteAction();
			}
			
			return null;
		}
	
}
