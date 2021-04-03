package com.jobsity.bowlingscoreboard.application;

public enum GameRunner {
	
	TEXT_INPUT("txt"),
	JSON_INPUT("json");

	private String extension;

	GameRunner(String extension) {
		this.extension = extension;
	}
	
	public static GameRunner of(String source) {
		GameRunner defaultRunner = TEXT_INPUT;
		for (GameRunner value : values()) {
			if (value.extension.equals(source)) {
				return value;
			}
		}
		return defaultRunner;
	}

}
