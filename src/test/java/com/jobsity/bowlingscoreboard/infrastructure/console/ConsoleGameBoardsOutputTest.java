package com.jobsity.bowlingscoreboard.infrastructure.console;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.domain.model.Game;
import com.jobsity.bowlingscoreboard.domain.model.Roll;
import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardsOutput;

public class ConsoleGameBoardsOutputTest {
	
	private Game game;
	
	@BeforeEach
	public void setUp() {
		this.game = new Game("Player");
	}

	@Test
	public void shouldCreateConsoleGameBoardFromGame() {
		roll(new Integer[] { 10, 7,3, 9,0, 10, 0,8, 8,2, null,6, 10, 10, 10,8,1  });
		
		GameBoardsOutput output = new ConsoleGameBoardsOutput(asList(this.game));
		
		assertThat(output.toString()).isEqualTo(
				"Frame		1		2		3		4		5		6		7		8		9		10"
				+ System.getProperty("line.separator")
				+ "Player"
				+ System.getProperty("line.separator")
				+ "Pinfalls		X	7	/	9	0		X	0	8	8	/	F	6		X		X	X	8	1"
				+ System.getProperty("line.separator")
				+ "Score		20		39		48		66		74		84		90		120		148		167"
				+ System.getProperty("line.separator")
				);
	}

	private void roll(Integer... rolls) {
		for(Integer roll: rolls) {
			this.game.roll(new Roll(roll));
		}
	}

}
