package com.jobsity.bowlingscoreboard;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;

public class ConsoleApplicationFactoryTest {
	@Test
	public void shouldThrowExceptionIfVarArgsIsNull() {
		assertThatThrownBy(() -> {
			new ConsoleApplicationFactory(null);
		})
		.isInstanceOf(InvalidInputFileException.class)
		.hasMessage("Input file cannot be blank.");
	}
	
	@Test
	public void shouldThrowExceptionIfVarArgsIsEmpty() {
		assertThatThrownBy(() -> {
			String[] args = new String[] {};
			new ConsoleApplicationFactory(args);
		})
		.isInstanceOf(InvalidInputFileException.class)
		.hasMessage("Input file cannot be blank.");
	}

}
