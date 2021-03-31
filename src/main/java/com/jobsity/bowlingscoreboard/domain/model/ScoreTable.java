package com.jobsity.bowlingscoreboard.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class ScoreTable {
	
	private List<Roll> rolls;
	
	public ScoreTable() {
		this.rolls = new ArrayList<>();
	}

	public void addRoll(Roll roll) {
		this.rolls.add(roll);
	}

}
