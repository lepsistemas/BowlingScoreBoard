package com.jobsity.bowlingscoreboard.application.usecase;

import com.jobsity.bowlingscoreboard.application.model.GameScore;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;

public interface GameScoreCalculationPort {
	
	GameScore calculate(ScoreTable table);

}
