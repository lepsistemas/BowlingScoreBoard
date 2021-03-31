package com.jobsity.bowlingscoreboard.infrastructure.dto;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class RollInput {
	
	private String pinsDown;
	
	public RollInput(String pinsDown) {
		this.pinsDown = pinsDown;
	}

	public String getPinsDown() {
		return pinsDown;
	}

}
