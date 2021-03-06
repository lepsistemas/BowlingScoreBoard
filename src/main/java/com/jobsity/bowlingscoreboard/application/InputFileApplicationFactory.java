package com.jobsity.bowlingscoreboard.application;

import java.util.HashMap;
import java.util.Map;

import com.jobsity.bowlingscoreboard.application.io.Output;

public class InputFileApplicationFactory {
	
	private Map<GameFileInput, ApplicationFactory> runners = new HashMap<>();
	private String[] args;
	
	public InputFileApplicationFactory(String[] args, Output output) {
		this.args = args;
		this.runners = new HashMap<>();
		this.runners.put(GameFileInput.TEXT_INPUT, new TextFileGameFactory(args, output));
		this.runners.put(GameFileInput.JSON_INPUT, new JsonFileGameFactory(args, output));
	}
	
	public ApplicationFactory create() {
		String extension = this.args[0].substring(this.args[0].lastIndexOf('.') + 1);
		return this.runners.get(GameFileInput.of(extension));
	}

}
