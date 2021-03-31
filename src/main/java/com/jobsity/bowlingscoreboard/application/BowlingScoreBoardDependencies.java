package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.application.usecase.GameScoreCalculationPort;

public class BowlingScoreBoardDependencies {

	private final Output output;
	private final Input input;
	private final GameScoreCalculationPort calculation;

	public BowlingScoreBoardDependencies(Output output, Input input, GameScoreCalculationPort calculation) {
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
	
	public GameScoreCalculationPort calculation() {
		return this.calculation;
	}

}
