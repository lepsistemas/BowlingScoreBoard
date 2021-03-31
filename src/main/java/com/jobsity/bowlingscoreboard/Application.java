package com.jobsity.bowlingscoreboard;

import com.jobsity.bowlingscoreboard.application.ApplicationFactory;
import com.jobsity.bowlingscoreboard.application.BowlingScoreBoard;

public class Application {
	
	static ApplicationFactory applicationFactory = new ConsoleApplicationFactory();
    
	public static void main(String[] args) {
		try {
			Application application = new Application();
			application.run(args);
		} catch (Exception e) {
            applicationFactory.output().write(e.getMessage());
        }
	}
	
	void run(String[] args) {
		BowlingScoreBoard board = applicationFactory.board();
		board.start(args);
	}
}
