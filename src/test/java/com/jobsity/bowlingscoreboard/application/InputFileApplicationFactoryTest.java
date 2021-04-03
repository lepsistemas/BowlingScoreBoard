package com.jobsity.bowlingscoreboard.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputFileApplicationFactoryTest {
	
	@Test
	public void shouldCreateTextGameRunnerForNullArgs() {
		ApplicationFactory gameFactory = new InputFileApplicationFactory(new String[] { "path/to/file" }, null).create();
		
		assertThat(gameFactory).isExactlyInstanceOf(TextFileGameFactory.class);
	}
	
	@Test
	public void shouldCreateTextGameRunner() {
		ApplicationFactory gameFactory = new InputFileApplicationFactory(new String[] { "path/to/file.txt" }, null).create();
		
		assertThat(gameFactory).isExactlyInstanceOf(TextFileGameFactory.class);
	}
	
	@Test
	public void shouldCreateJsonGameRunner() {
		ApplicationFactory gameFactory = new InputFileApplicationFactory(new String[] { "path/to/file.json" }, null).create();
		
		assertThat(gameFactory).isExactlyInstanceOf(JsonFileGameFactory.class);
	}

}
