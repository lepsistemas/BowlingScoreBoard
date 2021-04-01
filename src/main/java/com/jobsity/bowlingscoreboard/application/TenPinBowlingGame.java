package com.jobsity.bowlingscoreboard.application;

import java.util.List;
import java.util.stream.Collectors;

import com.jobsity.bowlingscoreboard.domain.model.Game;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.convert.ScoreTableInputToScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardOutput;
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
		
		List<Game> gameBoards = scoreTables.stream()
			.map(scoreTable -> this.dependencies.calculation().calculate(scoreTable))
			.collect(Collectors.toList());
		
		gameBoards.stream()
			.forEach(gameBoard -> {
				GameBoardOutput output = this.dependencies.formatter().format(gameBoard);
				this.dependencies.getOutput().write(output.toString());
			});
	}

}	
