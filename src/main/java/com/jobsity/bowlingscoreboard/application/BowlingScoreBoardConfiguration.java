package com.jobsity.bowlingscoreboard.application;

public class BowlingScoreBoardConfiguration {

	private Output output;
	private Input input;

	public BowlingScoreBoardConfiguration(Output output, Input input) {
		this.output = output;
		this.input = input;
	}

	public Output getOutput() {
		return this.output;
	}

	public Input getInput() {
		return this.input;
	}

}
