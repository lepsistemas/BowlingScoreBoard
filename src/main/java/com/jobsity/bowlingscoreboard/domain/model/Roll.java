package com.jobsity.bowlingscoreboard.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Roll {
	
	private static final Integer MAX_PINS_DOWN = Integer.valueOf(10);
	
	private Integer pinsDown;

	public Roll(Integer pinsDown) {
		this.pinsDown = pinsDown;
	}

	public boolean isMaxPinsDown() {
		return MAX_PINS_DOWN.compareTo(this.pinsDown) == 0;
	}

}
