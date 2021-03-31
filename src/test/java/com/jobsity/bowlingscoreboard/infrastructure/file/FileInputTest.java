package com.jobsity.bowlingscoreboard.infrastructure.file;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
		
		ScoreTableInput actual = input.read();
		
		ScoreTableInput expected = new ScoreTableInput();
		expected.addRoll(new RollInput("Jeff", "10"));
		expected.addRoll(new RollInput("John", "3"));
		expected.addRoll(new RollInput("John", "7"));
		
		assertThat(actual).isEqualTo(expected);
		// Ordre guaranteed
		assertThat(actual.getRolls().get(0)).isEqualTo(new RollInput("Jeff", "10"));
		assertThat(actual.getRolls().get(1)).isEqualTo(new RollInput("John", "3"));
		assertThat(actual.getRolls().get(2)).isEqualTo(new RollInput("John", "7"));
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
