package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.domain.model.GameBoard;
import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardOutput;

public interface Formatter {
	
	GameBoardOutput format(GameBoard board);

}
