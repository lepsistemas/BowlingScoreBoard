package com.jobsity.bowlingscoreboard.infrastructure.console;

import java.io.PrintStream;

import com.jobsity.bowlingscoreboard.application.io.Formatter;
import com.jobsity.bowlingscoreboard.application.io.Output;
import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardsOutput;

public class ConsoleOutput implements Output {
	
	private PrintStream printStream;

	public ConsoleOutput(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void write(GameBoardsOutput output) {
		this.printStream.print(((ConsoleGameBoardsOutput) output).toString());
	}

	@Override
	public Formatter formatter() {
		return new ConsoleFormatter();
	}

}
