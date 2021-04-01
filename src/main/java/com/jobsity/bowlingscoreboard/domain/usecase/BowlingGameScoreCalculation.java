package com.jobsity.bowlingscoreboard.domain.usecase;

import com.jobsity.bowlingscoreboard.domain.model.Game;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;

public interface BowlingGameScoreCalculation {
	
	Game calculate(ScoreTable table);

}
