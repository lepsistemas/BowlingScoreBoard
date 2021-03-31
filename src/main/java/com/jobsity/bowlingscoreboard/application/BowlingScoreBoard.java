package com.jobsity.bowlingscoreboard.application;

public class BowlingScoreBoard {
	
	private BowlingScoreBoardConfiguration configuration;

	public BowlingScoreBoard(BowlingScoreBoardConfiguration configuration) {
		this.configuration = configuration;
	}

	public void start(String[] args) {
		this.configuration.getOutput().write(args[0]);
	}

}
