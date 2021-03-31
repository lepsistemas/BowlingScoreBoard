package com.jobsity.bowlingscoreboard.application.usecase;

import com.jobsity.bowlingscoreboard.application.model.Game;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;

public class TenPinGameScoreCalculation implements BowlingGameScoreCalculation {
	
	public TenPinGameScoreCalculation() {
	}

	@Override
	public Game calculate(ScoreTable scoreTable) {
		Game game = new Game(scoreTable.getPlayer());
		
		scoreTable.getRolls().forEach(roll -> {
			game.roll(roll);
		});
		
		return game;
	}

}
