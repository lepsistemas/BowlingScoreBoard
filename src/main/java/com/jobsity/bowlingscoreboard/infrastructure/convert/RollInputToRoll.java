package com.jobsity.bowlingscoreboard.infrastructure.convert;

import com.jobsity.bowlingscoreboard.domain.model.Roll;
import com.jobsity.bowlingscoreboard.infrastructure.dto.RollInput;

public class RollInputToRoll {

	private static final String FOUL = "F";
	
	private RollInputToRoll() {}

	public static Roll convert(RollInput input) {
		Integer pinsDown = FOUL.equals(input.getPinsDown()) ? null : Integer.valueOf(input.getPinsDown());
		return new Roll(pinsDown);
	}

}
