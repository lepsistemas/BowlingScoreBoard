package com.jobsity.bowlingscoreboard.application.game;

import com.jobsity.bowlingscoreboard.application.io.Input;
import com.jobsity.bowlingscoreboard.application.io.Output;
import com.jobsity.bowlingscoreboard.domain.usecase.BowlingGameScoreCalculation;

public class TenPinBowlingGameDependencies {

	private final Output output;
	private final Input input;
	private final BowlingGameScoreCalculation calculation;

	public TenPinBowlingGameDependencies(Output output, Input input, BowlingGameScoreCalculation calculation) {
		this.output = output;
		this.input = input;
		this.calculation = calculation;
	}

	public Output getOutput() {
		return this.output;
	}

	public Input getInput() {
		return this.input;
	}
	
	public BowlingGameScoreCalculation calculation() {
		return this.calculation;
	}

}
