package com.jobsity.bowlingscoreboard.application.io;

import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardsOutput;

public interface Output {
	
	void write(GameBoardsOutput output);
	
	Formatter formatter();

}
