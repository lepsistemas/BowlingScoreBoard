package com.jobsity.bowlingscoreboard.infrastructure.console;

import java.io.PrintStream;

import com.jobsity.bowlingscoreboard.application.io.Output;

public class ConsoleOutput implements Output {
	
	private PrintStream printStream;

	public ConsoleOutput(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void write(String message) {
		this.printStream.print(message);
	}

}
