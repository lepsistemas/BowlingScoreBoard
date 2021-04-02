package com.jobsity.bowlingscoreboard.application.io;

import java.util.List;

import com.jobsity.bowlingscoreboard.domain.model.Game;

public interface Formatter {
	
	GameBoardsOutput format(List<Game> game);

}
