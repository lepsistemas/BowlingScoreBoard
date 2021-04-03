package com.jobsity.bowlingscoreboard.infrastructure.console;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.application.io.Formatter;
import com.jobsity.bowlingscoreboard.domain.model.Game;
import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardsOutput;

public class ConsoleFormatterTest {
	
	@Test
	public void shouldFOrmat() {
		Formatter formatter = new ConsoleFormatter();
		
		Game game = new Game("Player");
		
		GameBoardsOutput output = formatter.format(asList(game));
		
		assertThat(output).isExactlyInstanceOf(ConsoleGameBoardsOutput.class);
	}

}
