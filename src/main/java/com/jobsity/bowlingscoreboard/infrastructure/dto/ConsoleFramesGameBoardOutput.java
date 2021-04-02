package com.jobsity.bowlingscoreboard.infrastructure.dto;

public class ConsoleFramesGameBoardOutput {
	
	@Override
	public String toString() {
		StringBuilder formatted = new StringBuilder();
		formatted.append("Frame" + ConsoleGameBoardsOutput.TAB + ConsoleGameBoardsOutput.TAB);
		for(int frameCount = 1; frameCount <= 10; frameCount++) {
			formatted.append(frameCount);
			if (frameCount < 10) {
				formatted.append(ConsoleGameBoardsOutput.TAB + ConsoleGameBoardsOutput.TAB);
			}
		}
		formatted.append(ConsoleGameBoardsOutput.RETURN);
		return formatted.toString();
	}

}
