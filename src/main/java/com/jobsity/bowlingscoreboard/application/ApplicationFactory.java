package com.jobsity.bowlingscoreboard.application;

public interface ApplicationFactory {
	
	Output output();
	
	default BowlingScoreBoard board() {
		BowlingScoreBoardConfiguration configuration = new BowlingScoreBoardConfiguration();
		configuration.setOutput(this.output());
		return new BowlingScoreBoard(configuration);
	}

}
