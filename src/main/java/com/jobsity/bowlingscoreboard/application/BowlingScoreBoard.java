package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public class BowlingScoreBoard {
	
	private BowlingScoreBoardConfiguration configuration;

	public BowlingScoreBoard(BowlingScoreBoardConfiguration configuration) {
		this.configuration = configuration;
	}

	public void start() {
		ScoreTableInput scoreTable = this.configuration.getInput().read();
	}

}	
