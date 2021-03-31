package com.jobsity.bowlingscoreboard.infrastructure.convert;

import com.jobsity.bowlingscoreboard.domain.model.Roll;
import com.jobsity.bowlingscoreboard.infrastructure.dto.RollInput;

public class RollInputToRoll {

	private static final String FOUL = "F";

	public static Roll convert(RollInput input) {
		Integer pinsDown;
		if (FOUL.equals(input.getPinsDown())) {
			pinsDown = 0;
		} else {
			pinsDown = Integer.valueOf(input.getPinsDown());
		}
		return new Roll(input.getPlayer(), pinsDown);
	}

}
