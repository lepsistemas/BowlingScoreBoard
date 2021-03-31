package com.jobsity.bowlingscoreboard.infrastructure.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class ScoreTableInput {
	
	private String player;
	private List<RollInput> rolls;
	
	public ScoreTableInput(String player) {
		this.player = player;
		this.rolls = new ArrayList<>();
	}
	
	public void addRoll(RollInput roll) {
		this.rolls.add(roll);
	}

}
