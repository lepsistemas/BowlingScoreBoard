package com.jobsity.bowlingscoreboard;

import com.jobsity.bowlingscoreboard.application.ApplicationFactory;
import com.jobsity.bowlingscoreboard.application.game.BowlingGame;

public class Application {
	
	public static void main(String[] args) {
		try {
			Application application = new Application();
			application.run(new FileInputApplicationFactory(args));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
        }
	}
	
	void run(ApplicationFactory applicationFactory) {
		BowlingGame scoreBoard = applicationFactory.board();
		scoreBoard.start();
	}
}
