package com.jobsity.bowlingscoreboard.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;
import com.jobsity.bowlingscoreboard.infrastructure.console.ConsoleOutput;

public class TextFileGameFactoryTest {
	
	@Test
	public void shouldThrowExceptionIfVarArgsIsNull() {
		assertThatThrownBy(() -> {
			new TextFileGameFactory(null, null);
		})
		.isInstanceOf(InvalidInputFileException.class)
		.hasMessage("Input file cannot be blank.");
	}
	
	@Test
	public void shouldThrowExceptionIfVarArgsIsEmpty() {
		assertThatThrownBy(() -> {
			String[] args = new String[] {};
			new TextFileGameFactory(args, null);
		})
		.isInstanceOf(InvalidInputFileException.class)
		.hasMessage("Input file cannot be blank.");
	}
	
	@Test
	public void shouldCreateApplication() {
		TextFileGameFactory factory = new TextFileGameFactory(new String[] { "path/to/file" }, new ConsoleOutput(System.out));
		
		assertThat(factory.output()).isNotNull();
		assertThat(factory.input()).isNotNull();
		assertThat(factory.calculation()).isNotNull();
	}

}
