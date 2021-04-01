package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.domain.usecase.BowlingGameScoreCalculation;

public class BowlingGameDependencies {

	private final Output output;
	private final Input input;
	private final BowlingGameScoreCalculation calculation;
	private final Formatter formatter;

	public BowlingGameDependencies(Output output, Input input, BowlingGameScoreCalculation calculation, Formatter formatter) {
		this.output = output;
		this.input = input;
		this.calculation = calculation;
		this.formatter = formatter;
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

	public Formatter formatter() {
		return this.formatter;
	}

}
