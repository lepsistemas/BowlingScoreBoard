package com.jobsity.bowlingscoreboard.infrastructure.convert;

import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public class ScoreTableInputToScoreTable {

	public static ScoreTable convert(ScoreTableInput input) {
		ScoreTable scoreTable = new ScoreTable(input.getPlayer());
		input.getRolls().forEach(rollInput -> {
			scoreTable.addRoll(RollInputToRoll.convert(rollInput));
		});
		return scoreTable;
	}

}
