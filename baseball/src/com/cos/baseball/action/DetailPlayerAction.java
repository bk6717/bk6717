package com.cos.baseball.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.baseball.model.Player;
import com.cos.baseball.repository.PlayerRepository;
import com.google.gson.Gson;

public class DetailPlayerAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		
		PlayerRepository playerRepository =
				PlayerRepository.getInstance();
		
		String playerName = request.getParameter("playerName");
		
		List<Player> players = playerRepository.player(playerName);
		
		String playerJson = gson.toJson(players);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/Json charser=utf-8");
		
		PrintWriter pw = response.getWriter();
		pw.println(playerJson);
		
		System.out.println(playerJson+"2");
		
	}
}
