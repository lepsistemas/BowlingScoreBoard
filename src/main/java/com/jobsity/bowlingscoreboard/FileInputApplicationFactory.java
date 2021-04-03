package com.jobsity.bowlingscoreboard;

import com.jobsity.bowlingscoreboard.application.ApplicationFactory;
import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;
import com.jobsity.bowlingscoreboard.application.io.Input;
import com.jobsity.bowlingscoreboard.application.io.Output;
import com.jobsity.bowlingscoreboard.domain.usecase.BowlingGameScoreCalculation;
import com.jobsity.bowlingscoreboard.domain.usecase.TenPinGameScoreCalculation;
import com.jobsity.bowlingscoreboard.infrastructure.file.FileInput;

public class FileInputApplicationFactory implements ApplicationFactory {

	private String[] args;
	private Output output;

	public FileInputApplicationFactory(String[] args, Output output) {
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
		return new FileInput(args);
	}

	@Override
	public BowlingGameScoreCalculation calculation() {
		return new TenPinGameScoreCalculation();
	}

}
