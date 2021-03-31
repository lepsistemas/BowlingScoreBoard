package com.jobsity.bowlingscoreboard.application;

public interface ApplicationFactory {
	
	Output output();
	Input input();
	
	default BowlingScoreBoard board() {
		BowlingScoreBoardConfiguration configuration = new BowlingScoreBoardConfiguration(this.output(), this.input());
		return new BowlingScoreBoard(configuration);
	}

}
