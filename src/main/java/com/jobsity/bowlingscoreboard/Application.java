package com.jobsity.bowlingscoreboard;

import com.jobsity.bowlingscoreboard.application.ApplicationFactory;
import com.jobsity.bowlingscoreboard.application.InputFileApplicationFactory;
import com.jobsity.bowlingscoreboard.application.game.BowlingGame;
import com.jobsity.bowlingscoreboard.infrastructure.console.ConsoleOutput;

public class Application {
	
	public static void main(String[] args) {
		try {
			Application application = new Application();
			ApplicationFactory factory = new InputFileApplicationFactory(args, new ConsoleOutput(System.out)).create();
			application.run(factory);
		} catch (Exception e) {
			System.out.println(e.getMessage());
        }
	}
	
	private void run(ApplicationFactory factory) {
		BowlingGame game = factory.game();
		game.start();
	}
}
