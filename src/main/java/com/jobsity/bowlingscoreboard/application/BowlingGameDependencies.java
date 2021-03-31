package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.application.usecase.BowlingGameScoreCalculation;

public class BowlingGameDependencies {

	private final Output output;
	private final Input input;
	private final BowlingGameScoreCalculation calculation;

	public BowlingGameDependencies(Output output, Input input, BowlingGameScoreCalculation calculation) {
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
