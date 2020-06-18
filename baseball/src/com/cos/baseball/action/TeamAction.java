package com.cos.baseball.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.baseball.model.Team;
import com.cos.baseball.repository.TeamRepository;

public class TeamAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamRepository teamRepository =
				TeamRepository.getInstance();
		
		List<Team> teams = teamRepository.findAll();
		
		request.setAttribute("teams", teams);
		
		RequestDispatcher dis = 
				request.getRequestDispatcher("home.jsp");
		
		dis.forward(request, response);
	}
}
