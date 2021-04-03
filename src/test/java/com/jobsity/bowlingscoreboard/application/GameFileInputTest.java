package com.jobsity.bowlingscoreboard.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GameFileInputTest {
	
	@Test
	public void shouldReturnTextGameFileInput() {
		GameFileInput gameFileInput = GameFileInput.of("txt");
		
		assertThat(gameFileInput).isEqualTo(GameFileInput.TEXT_INPUT);
	}
	
	@Test
	public void shouldReturnJsonGameFileInput() {
		GameFileInput gameFileInput = GameFileInput.of("json");
		
		assertThat(gameFileInput).isEqualTo(GameFileInput.JSON_INPUT);
	}
	
	@Test
	public void shouldReturnDefaultGameFileInput() {
		GameFileInput gameFileInput = GameFileInput.of("");
		
		assertThat(gameFileInput).isEqualTo(GameFileInput.TEXT_INPUT);
	}

}
