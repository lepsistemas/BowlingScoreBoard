package com.jobsity.bowlingscoreboard;

import com.jobsity.bowlingscoreboard.application.GameFactory;
import com.jobsity.bowlingscoreboard.application.GameRunnerFactory;
import com.jobsity.bowlingscoreboard.application.game.BowlingGame;
import com.jobsity.bowlingscoreboard.infrastructure.console.ConsoleOutput;

public class Application {
	
	public static void main(String[] args) {
		try {
			Application application = new Application();
			GameFactory gameFactory = new GameRunnerFactory(args, new ConsoleOutput(System.out)).factory();
			application.run(gameFactory);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
        }
	}
	
	private void run(GameFactory gameFactory) {
		BowlingGame game = gameFactory.game();
		game.start();
	}
}
