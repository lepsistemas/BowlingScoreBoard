package com.jobsity.bowlingscoreboard.features;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.jobsity.bowlingscoreboard.FileInputApplicationFactory;
import com.jobsity.bowlingscoreboard.application.ApplicationFactory;
import com.jobsity.bowlingscoreboard.application.game.BowlingGame;
import com.jobsity.bowlingscoreboard.infrastructure.console.ConsoleOutput;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReadScoreTableFromInputFileAndCreateGameBoardFeature {
	
	private ApplicationFactory factory;
	
	private PrintStream output;
	
	@Given("An existing Score Table in path {string}")
	public void an_existing_score_table_in_path(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		String inputFilePath = classLoader.getResource(path).getPath();
		
		this.output = mock(PrintStream.class);
		this.factory = new FileInputApplicationFactory(new String[] { inputFilePath }, new ConsoleOutput(this.output));
	}

	@When("I run the game")
	public void i_input_this_file_into_the_application() {
		BowlingGame game = this.factory.game();
		game.start();
	}

	@Then("I should see the Game Board {string}")
	public void i_should_see_the_game_board(String result) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		String expected = this.readFromInputStream(classLoader.getResourceAsStream(result));
		
		verify(this.output).print(expected);
	}
	
	private String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}

}
