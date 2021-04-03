package com.jobsity.bowlingscoreboard.application;

public enum GameFileInput {
	
	TEXT_INPUT("txt"),
	JSON_INPUT("json");

	private String extension;

	GameFileInput(String extension) {
		this.extension = extension;
	}
	
	public static GameFileInput of(String source) {
		for (GameFileInput value : values()) {
			if (value.extension.equals(source)) {
				return value;
			}
		}
		return TEXT_INPUT;
	}

}
