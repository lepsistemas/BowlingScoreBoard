package com.jobsity.bowlingscoreboard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;
import com.jobsity.bowlingscoreboard.infrastructure.console.ConsoleOutput;

public class FileInputApplicationFactoryTest {
	@Test
	public void shouldThrowExceptionIfVarArgsIsNull() {
		assertThatThrownBy(() -> {
			new FileInputApplicationFactory(null, null);
		})
		.isInstanceOf(InvalidInputFileException.class)
		.hasMessage("Input file cannot be blank.");
	}
	
	@Test
	public void shouldThrowExceptionIfVarArgsIsEmpty() {
		assertThatThrownBy(() -> {
			String[] args = new String[] {};
			new FileInputApplicationFactory(args, null);
		})
		.isInstanceOf(InvalidInputFileException.class)
		.hasMessage("Input file cannot be blank.");
	}
	
	@Test
	public void shouldCreateApplication() {
		FileInputApplicationFactory factory = new FileInputApplicationFactory(new String[] { "path/to/file" }, new ConsoleOutput(System.out));
		
		assertThat(factory.output()).isNotNull();
		assertThat(factory.input()).isNotNull();
		assertThat(factory.calculation()).isNotNull();
	}

}
