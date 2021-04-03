package com.jobsity.bowlingscoreboard.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class ScoreTable {
	
	private String player;
	private List<Roll> rolls;
	
	public ScoreTable(String player) {
		this.player = player;
		this.rolls = new ArrayList<>();
	}

	public void addRoll(Roll roll) {
		this.rolls.add(roll);
	}
	
	public String getPlayer() {
		return this.player;
	}
	
	public List<Roll> getRolls() {
		return this.rolls;
	}

}
