package com.jobsity.bowlingscoreboard.application.game;

import java.util.List;
import java.util.stream.Collectors;

import com.jobsity.bowlingscoreboard.domain.model.Game;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.convert.ScoreTableInputToScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public class TenPinBowlingGame implements BowlingGame {
	
	private TenPinBowlingGameDependencies dependencies;

	public TenPinBowlingGame(TenPinBowlingGameDependencies dependencies) {
		this.dependencies = dependencies;
	}

	@Override
	public void start() {
		List<ScoreTableInput> scoreTableInputs = this.dependencies.getInput().read();
		
		List<ScoreTable> scoreTables = scoreTableInputs.stream()
				.map(ScoreTableInputToScoreTable::convert)
				.collect(Collectors.toList());
		
		List<Game> gameBoards = scoreTables.stream()
			.map(scoreTable -> this.dependencies.calculation().calculate(scoreTable))
			.collect(Collectors.toList());
		
		gameBoards.stream()
			.forEach(gameBoard -> {
				this.dependencies.getOutput().write(gameBoard.toString());
			});
	}

}	
