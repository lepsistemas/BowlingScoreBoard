package com.jobsity.bowlingscoreboard.application.model;

import java.util.ArrayList;
import java.util.List;

import com.jobsity.bowlingscoreboard.domain.model.Roll;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Frame {

	private List<Roll> rolls;

	public Frame() {
		this.rolls = new ArrayList<>();
	}

	public void addRoll(Roll roll) {
		this.rolls.add(roll);
	}
	
	public boolean isEnded() {
		return this.rolls.size() == 2;
	}
	
	public Integer getScore() {
		return this.rolls.stream()
				.map(Roll::getPinsDown)
				.reduce(0, Integer::sum);
	}

	public boolean isFirstTry() {
		return this.rolls.isEmpty();
	}

}
