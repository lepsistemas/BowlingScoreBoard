package com.jobsity.bowlingscoreboard;

import com.jobsity.bowlingscoreboard.application.ApplicationFactory;
import com.jobsity.bowlingscoreboard.application.Output;
import com.jobsity.bowlingscoreboard.infrastructure.console.ConsoleOutput;

public class ConsoleApplicationFactory implements ApplicationFactory {

	@Override
	public Output output() {
		return new ConsoleOutput(System.out);
	}

}
