package com.cos.baseball.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
	private int id;
	private int number;
	private String playerName;
	private String position;
	private String teamName;
}
