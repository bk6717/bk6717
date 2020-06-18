package com.cos.baseball.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.baseball.db.DBConn;
import com.cos.baseball.model.Player;
import com.cos.baseball.model.Team;

public class PlayerRepository {
	private static final String TAG = "TeamRepository";
	private static PlayerRepository instance = new PlayerRepository();
	private PlayerRepository() {}
	public static PlayerRepository getInstance() {
		return instance;
	}
	
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection conn = null;
	
public List<Player> player(String playerName) {
		
		final String SQL = "SELECT playernum, playerName, position FROM player where playerName = ?";
		
		try {			
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, playerName);
			rs = pstmt.executeQuery();
			
			List<Player> players = new ArrayList<>();
			// while문 
			while (rs.next()) {
				Player player = Player.builder()
						.number(rs.getInt(1))
						.playerName(rs.getString(2))
						.position(rs.getString(3))
						.build();
				players.add(player);
			}
				return players;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+" player : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return null;
	}

}
