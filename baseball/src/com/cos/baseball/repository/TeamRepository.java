package com.cos.baseball.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.baseball.db.DBConn;
import com.cos.baseball.model.Player;
import com.cos.baseball.model.Team;

public class TeamRepository {
	private static final String TAG = "TeamRepository";
	private static TeamRepository instance = new TeamRepository();
	private TeamRepository() {}
	public static TeamRepository getInstance() {
		return instance;
	}
	
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection conn = null;
	
public List<Team> findAll() {
		
		final String SQL = "SELECT * FROM team ORDER BY lank";
		try {
			
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			List<Team> teams = new ArrayList<>();
			// while문 
			while (rs.next()) {
				Team team = Team.builder()
						.lank(rs.getInt(1))
						.teamName(rs.getString(2))
						.build();
						teams.add(team);
				
			}
				return teams;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+" findAll : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return null;
	}



public List<Player> findPlayer(String teamName) {
	
	final String SQL = "SELECT playernum, playername FROM player where teamname = ? ";
	
	try {
		
		conn = DBConn.getConnection();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, teamName);
		rs = pstmt.executeQuery();
		
		List<Player> players = new ArrayList<>();
		
		
		// while문 
		while (rs.next()) {
			Player player = Player.builder()
					.number(rs.getInt(1))
					.playerName(rs.getString(2))
					.build();
				players.add(player);
		}
			return players;
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(TAG+" findPlayer : "+e.getMessage());
	} finally {
		DBConn.close(conn, pstmt, rs);
	}
	
	return null;
}
	
}