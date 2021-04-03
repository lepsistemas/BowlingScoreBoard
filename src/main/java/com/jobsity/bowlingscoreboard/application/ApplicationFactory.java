package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.application.game.BowlingGame;
import com.jobsity.bowlingscoreboard.application.game.TenPinBowlingGame;
import com.jobsity.bowlingscoreboard.application.game.TenPinBowlingGameDependencies;
import com.jobsity.bowlingscoreboard.application.io.Input;
import com.jobsity.bowlingscoreboard.application.io.Output;
import com.jobsity.bowlingscoreboard.domain.usecase.BowlingGameScoreCalculation;

public interface ApplicationFactory {
	
	Output output();
	Input input();
	BowlingGameScoreCalculation calculation();
	
	default BowlingGame game() {
		TenPinBowlingGameDependencies dependencies = new TenPinBowlingGameDependencies(this.output(), this.input(), this.calculation());
		return new TenPinBowlingGame(dependencies);
	}

}
