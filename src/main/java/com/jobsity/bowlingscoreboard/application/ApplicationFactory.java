package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.application.usecase.BowlingGameScoreCalculation;

public interface ApplicationFactory {
	
	Output output();
	Input input();
	BowlingGameScoreCalculation calculation();
	Formatter formatter();
	
	default TenPinBowlingGame board() {
		BowlingGameDependencies configuration = new BowlingGameDependencies(this.output(), this.input(), this.calculation(), this.formatter());
		return new TenPinBowlingGame(configuration);
	}

}
