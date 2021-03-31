package com.jobsity.bowlingscoreboard.application.usecase;

import com.jobsity.bowlingscoreboard.application.model.Game;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;

public interface BowlingGameScoreCalculation {
	
	Game calculate(ScoreTable table);

}
