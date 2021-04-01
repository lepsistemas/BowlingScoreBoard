package com.jobsity.bowlingscoreboard.application.usecase;

import com.jobsity.bowlingscoreboard.domain.model.GameBoard;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;

public class TenPinGameScoreCalculation implements BowlingGameScoreCalculation {
	
	public TenPinGameScoreCalculation() {
	}

	@Override
	public GameBoard calculate(ScoreTable scoreTable) {
		GameBoard game = new GameBoard(scoreTable.getPlayer());
		
		scoreTable.getRolls().forEach(roll -> {
			game.roll(roll);
		});
		
		return game;
	}

}
