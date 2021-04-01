package com.jobsity.bowlingscoreboard.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Frame {
	
	private static final Integer MAX_PINS_DOWN = Integer.valueOf(10);

	private List<Roll> rolls;
	private Integer bonus;

	public Frame() {
		this.rolls = new ArrayList<>();
		this.bonus = 0;
	}

	public void addRoll(Roll roll) {
		this.rolls.add(roll);
	}
	
	public boolean isOver() {
		return this.madeStrike() || this.madeSpare() || this.rolls.size() == 2;
	}
	
	public Integer getScore() {
		return this.rolls.stream()
				.map(Roll::getPinsDown)
				.reduce(this.bonus, Integer::sum);
	}

	public boolean madeStrike() {
		return this.rolls.size() == 1 && MAX_PINS_DOWN.compareTo(this.rolls.get(0).getPinsDown()) == 0;
	}
	
	public boolean madeSpare() {
		return this.rolls.size() == 2 && MAX_PINS_DOWN.compareTo(this.getScore()) == 0;
	}

	public void addBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Roll getFirstRoll() {
		return this.rolls.get(0);
	}

}
