package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.convert.ScoreTableInputToScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public class BowlingScoreBoard {
	
	private BowlingScoreBoardDependencies dependencies;

	public BowlingScoreBoard(BowlingScoreBoardDependencies configuration) {
		this.dependencies = configuration;
	}

	public void start() {
		ScoreTableInput scoreTableInput = this.dependencies.getInput().read();
		ScoreTable scoreTable = ScoreTableInputToScoreTable.convert(scoreTableInput);
		this.dependencies.calculation().calculate(scoreTable);
	}

}	
