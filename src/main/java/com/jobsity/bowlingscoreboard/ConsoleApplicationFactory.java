package com.jobsity.bowlingscoreboard;

import com.jobsity.bowlingscoreboard.application.ApplicationFactory;
import com.jobsity.bowlingscoreboard.application.Formatter;
import com.jobsity.bowlingscoreboard.application.Input;
import com.jobsity.bowlingscoreboard.application.Output;
import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;
import com.jobsity.bowlingscoreboard.application.usecase.BowlingGameScoreCalculation;
import com.jobsity.bowlingscoreboard.application.usecase.TenPinGameScoreCalculation;
import com.jobsity.bowlingscoreboard.infrastructure.console.ConsoleOutput;
import com.jobsity.bowlingscoreboard.infrastructure.file.FileInput;

public class ConsoleApplicationFactory implements ApplicationFactory {

	private String[] args;

	public ConsoleApplicationFactory(String[] args) {
		this.args = args;
		if (args == null || args.length == 0) {
			throw new InvalidInputFileException("Input file cannot be blank.");
		}
	}

	@Override
	public Output output() {
		return new ConsoleOutput(System.out);
	}
	
	@Override
	public Input input() {
		return new FileInput(args);
	}

	@Override
	public BowlingGameScoreCalculation calculation() {
		return new TenPinGameScoreCalculation();
	}
	
	@Override
	public Formatter formatter() {
		return null;
	}

}
