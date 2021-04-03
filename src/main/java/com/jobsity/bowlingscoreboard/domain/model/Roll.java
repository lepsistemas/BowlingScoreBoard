package com.jobsity.bowlingscoreboard.domain.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Roll {
	
	private Integer pinsDown;

	public Roll(Integer pinsDown) {
		this.pinsDown = pinsDown;
	}
	
	public Integer getPinsDown() {
		return this.pinsDown;
	}

}
