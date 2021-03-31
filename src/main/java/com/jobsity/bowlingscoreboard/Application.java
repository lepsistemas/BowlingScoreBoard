package com.jobsity.bowlingscoreboard;

import com.jobsity.bowlingscoreboard.application.ApplicationFactory;
import com.jobsity.bowlingscoreboard.application.BowlingScoreBoard;

public class Application {
	
	public static void main(String[] args) {
		try {
			Application application = new Application();
			application.run(new ConsoleApplicationFactory(args));
		} catch (Exception e) {
			System.out.println(e.getMessage());
        }
	}
	
	void run(ApplicationFactory applicationFactory) {
		BowlingScoreBoard scoreBoard = applicationFactory.board();
		scoreBoard.start();
	}
}
