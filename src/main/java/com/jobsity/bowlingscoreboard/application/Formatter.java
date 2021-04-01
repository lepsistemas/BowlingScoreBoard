package com.jobsity.bowlingscoreboard.application;

import com.jobsity.bowlingscoreboard.domain.model.Game;
import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardOutput;

public interface Formatter {
	
	GameBoardOutput format(Game board);

}
