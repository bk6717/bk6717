package com.cos.baseball.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.baseball.action.Action;
import com.cos.baseball.action.DetailPlayerAction;
import com.cos.baseball.action.PlayerListAction;
import com.cos.baseball.action.TeamAction;

@WebServlet("/player")
public class PlayerController extends HttpServlet{
	private static final String TAG = "ProductController";
	private static final long serialVersionUID = 1L;
	
	    public PlayerController() {
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
			if(cmd.equals("detailPlayer")) {
				return new DetailPlayerAction();
			}
			
			return null;
		}
	
}