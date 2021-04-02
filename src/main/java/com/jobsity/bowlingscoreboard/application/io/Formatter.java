package com.jobsity.bowlingscoreboard.application.io;

import java.util.List;

import com.jobsity.bowlingscoreboard.domain.model.Game;
import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardsOutput;

public interface Formatter {
	
	GameBoardsOutput format(List<Game> game);

}
