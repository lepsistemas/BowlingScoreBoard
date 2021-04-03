package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;
import com.jobsity.bowlingscoreboard.application.io.Input;
import com.jobsity.bowlingscoreboard.application.io.Output;
import com.jobsity.bowlingscoreboard.domain.usecase.BowlingGameScoreCalculation;
import com.jobsity.bowlingscoreboard.domain.usecase.TenPinGameScoreCalculation;
import com.jobsity.bowlingscoreboard.infrastructure.file.TextInput;

public class TextFileGameFactory implements ApplicationFactory {

	private String[] args;
	private Output output;

	public TextFileGameFactory(String[] args, Output output) {
		this.args = args;
		this.output = output;
		if (args == null || args.length == 0) {
			throw new InvalidInputFileException("Input file cannot be blank.");
		}
	}

	@Override
	public Output output() {
		return this.output;
	}
	
	@Override
	public Input input() {
		return new TextInput(args);
	}

	@Override
	public BowlingGameScoreCalculation calculation() {
		return new TenPinGameScoreCalculation();
	}

}
