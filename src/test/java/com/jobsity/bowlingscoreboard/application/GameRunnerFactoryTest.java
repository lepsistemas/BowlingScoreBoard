package com.jobsity.bowlingscoreboard.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GameRunnerFactoryTest {
	
	@Test
	public void shouldCreateTextGameRunnerForNullArgs() {
		GameFactory gameFactory = new GameRunnerFactory(new String[] { "path/to/file" }, null).factory();
		
		assertThat(gameFactory).isExactlyInstanceOf(TextFileGameFactory.class);
	}
	
	@Test
	public void shouldCreateTextGameRunner() {
		GameFactory gameFactory = new GameRunnerFactory(new String[] { "path/to/file.txt" }, null).factory();
		
		assertThat(gameFactory).isExactlyInstanceOf(TextFileGameFactory.class);
	}
	
	@Test
	public void shouldCreateJsonGameRunner() {
		GameFactory gameFactory = new GameRunnerFactory(new String[] { "path/to/file.json" }, null).factory();
		
		assertThat(gameFactory).isExactlyInstanceOf(JsonFileGameFactory.class);
	}

}
