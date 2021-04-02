package com.jobsity.bowlingscoreboard.infrastructure.console;

import java.util.List;

import com.jobsity.bowlingscoreboard.application.io.Formatter;
import com.jobsity.bowlingscoreboard.domain.model.Game;
import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardsOutput;

public class ConsoleFormatter implements Formatter {

	@Override
	public GameBoardsOutput format(List<Game> games) {
		return new ConsoleGameBoardsOutput(games);
	}

}
