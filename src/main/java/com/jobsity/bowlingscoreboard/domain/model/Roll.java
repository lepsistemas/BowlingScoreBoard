package com.jobsity.bowlingscoreboard.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Roll {
	
	private Integer pinsDown;

	public Roll(Integer pinsDown) {
		this.pinsDown = pinsDown;
	}

}
