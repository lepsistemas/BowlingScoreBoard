package com.jobsity.bowlingscoreboard.application;

import java.util.List;
import java.util.stream.Collectors;

import com.jobsity.bowlingscoreboard.application.model.Game;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.convert.ScoreTableInputToScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public class TenPinBowlingGame {
	
	private BowlingGameDependencies dependencies;

	public TenPinBowlingGame(BowlingGameDependencies dependencies) {
		this.dependencies = dependencies;
	}

	public void start() {
		List<ScoreTableInput> scoreTableInputs = this.dependencies.getInput().read();
		List<ScoreTable> scoreTables = scoreTableInputs.stream()
				.map(ScoreTableInputToScoreTable::convert)
				.collect(Collectors.toList());
		
		List<Game> game = scoreTables.stream()
			.map(scoreTable -> this.dependencies.calculation().calculate(scoreTable))
			.collect(Collectors.toList());
		
		System.out.println(game);
	}

}	
