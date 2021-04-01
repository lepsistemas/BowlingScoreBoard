package com.jobsity.bowlingscoreboard.domain.usecase;

import com.jobsity.bowlingscoreboard.domain.model.Game;
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
