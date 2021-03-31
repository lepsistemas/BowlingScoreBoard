package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.application.usecase.GameScoreCalculationPort;

public interface ApplicationFactory {
	
	Output output();
	Input input();
	GameScoreCalculationPort calculation();
	
	default BowlingScoreBoard board() {
		BowlingScoreBoardDependencies configuration = new BowlingScoreBoardDependencies(this.output(), this.input(), this.calculation());
		return new BowlingScoreBoard(configuration);
	}

}
