package com.jobsity.bowlingscoreboard.application;

import java.util.HashMap;
import java.util.Map;

import com.jobsity.bowlingscoreboard.application.io.Output;

public class GameRunnerFactory {
	
	private Map<GameRunner, GameFactory> runners = new HashMap<>();
	private String[] args;
	
	public GameRunnerFactory(String[] args, Output output) {
		this.args = args;
		this.runners = new HashMap<>();
		this.runners.put(GameRunner.TEXT_INPUT, new TextFileGameFactory(args, output));
		this.runners.put(GameRunner.JSON_INPUT, new JsonFileGameFactory(args, output));
	}
	
	public GameFactory factory() {
		GameRunner runner = GameRunner.TEXT_INPUT;
		String extension = this.args[0].substring(this.args[0].lastIndexOf('.') + 1);
		runner = GameRunner.of(extension);
		return this.runners.get(runner);
	}

}
