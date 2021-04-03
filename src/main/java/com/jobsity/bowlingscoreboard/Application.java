package com.jobsity.bowlingscoreboard;

import com.jobsity.bowlingscoreboard.application.ApplicationFactory;
import com.jobsity.bowlingscoreboard.application.game.BowlingGame;
import com.jobsity.bowlingscoreboard.infrastructure.console.ConsoleOutput;

public class Application {
	
	public static void main(String[] args) {
		try {
			Application application = new Application();
			application.run(new FileInputApplicationFactory(args, new ConsoleOutput(System.out)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
        }
	}
	
	private void run(ApplicationFactory applicationFactory) {
		BowlingGame game = applicationFactory.game();
		game.start();
	}
}
