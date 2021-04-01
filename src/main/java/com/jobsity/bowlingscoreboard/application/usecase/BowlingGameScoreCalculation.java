package com.jobsity.bowlingscoreboard.application.usecase;

import com.jobsity.bowlingscoreboard.domain.model.GameBoard;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;

public interface BowlingGameScoreCalculation {
	
	GameBoard calculate(ScoreTable table);

}
