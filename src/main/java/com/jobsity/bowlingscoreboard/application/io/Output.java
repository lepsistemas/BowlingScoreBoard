package com.jobsity.bowlingscoreboard.application.io;

public interface Output {
	
	void write(GameBoardsOutput output);
	
	Formatter formatter();

}
