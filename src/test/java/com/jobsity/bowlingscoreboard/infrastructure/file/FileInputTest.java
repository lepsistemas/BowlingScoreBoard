package com.jobsity.bowlingscoreboard.infrastructure.file;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.application.Input;
import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;
import com.jobsity.bowlingscoreboard.infrastructure.dto.RollInput;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public class FileInputTest {
	
	@Test
	public void shouldConvertInputFileToScoreTableInput() {
		ClassLoader classLoader = getClass().getClassLoader();
		String inputFilePath = classLoader.getResource("fake-game-input.txt").getPath();
		
		Input input = new FileInput(new String [] { inputFilePath });
		
		List<ScoreTableInput> actual = input.read();
		
		ScoreTableInput playerOneScoreTable = new ScoreTableInput("Jeff");
		playerOneScoreTable.addRoll(new RollInput("10"));
		
		ScoreTableInput playerTwoScoreTable = new ScoreTableInput("John");
		playerTwoScoreTable.addRoll(new RollInput("3"));
		playerTwoScoreTable.addRoll(new RollInput("7"));
		
		assertThat(actual.get(0)).isEqualTo(playerOneScoreTable);
		assertThat(actual.get(1)).isEqualTo(playerTwoScoreTable);
	}
	
	@Test
	public void shouldThrowExceptionForInvalidInputFile() {
		Input input = new FileInput(new String [] { "invalid-input.txt" });
		
		assertThatThrownBy(() -> {
			input.read();
		})
		.isInstanceOf(InvalidInputFileException.class)
		.hasMessage("Invalid input file: invalid-input.txt.");
	}

}
