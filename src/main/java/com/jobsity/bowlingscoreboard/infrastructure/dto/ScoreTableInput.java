package com.jobsity.bowlingscoreboard.infrastructure.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;

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
	
	public String getPlayer() {
		return this.player;
	}
	
	public List<RollInput> getRolls() {
		return this.rolls;
	}

}
