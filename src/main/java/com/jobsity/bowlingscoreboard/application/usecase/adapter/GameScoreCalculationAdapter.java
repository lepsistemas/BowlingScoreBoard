package com.jobsity.bowlingscoreboard.application.usecase.adapter;

import com.jobsity.bowlingscoreboard.application.model.GameScore;
import com.jobsity.bowlingscoreboard.application.usecase.GameScoreCalculationPort;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;

public class GameScoreCalculationAdapter implements GameScoreCalculationPort {

	@Override
	public GameScore calculate(ScoreTable table) {
		throw new UnsupportedOperationException("Method not implemented");
	}

}
