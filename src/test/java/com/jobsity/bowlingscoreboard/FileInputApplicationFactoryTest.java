package com.jobsity.bowlingscoreboard;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;

public class FileInputApplicationFactoryTest {
	@Test
	public void shouldThrowExceptionIfVarArgsIsNull() {
		assertThatThrownBy(() -> {
			new FileInputApplicationFactory(null);
		})
		.isInstanceOf(InvalidInputFileException.class)
		.hasMessage("Input file cannot be blank.");
	}
	
	@Test
	public void shouldThrowExceptionIfVarArgsIsEmpty() {
		assertThatThrownBy(() -> {
			String[] args = new String[] {};
			new FileInputApplicationFactory(args);
		})
		.isInstanceOf(InvalidInputFileException.class)
		.hasMessage("Input file cannot be blank.");
	}

}
