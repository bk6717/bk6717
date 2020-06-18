package com.cos.baseball.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.baseball.model.Player;
import com.cos.baseball.model.Team;
import com.cos.baseball.repository.TeamRepository;
import com.google.gson.Gson;

public class PlayerListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		
		TeamRepository teamRepository =
				TeamRepository.getInstance();
		
		String teamName = request.getParameter("teamName");
		
		List<Player> player = teamRepository.findPlayer(teamName);
		
		String playerJson = gson.toJson(player);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/Json charser=utf-8");
		
		PrintWriter pw = response.getWriter();
		pw.println(playerJson);
		
		System.out.println(playerJson);
	}
}
