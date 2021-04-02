package com.jobsity.bowlingscoreboard.infrastructure.dto;

import java.util.List;

import com.jobsity.bowlingscoreboard.domain.model.Frame;
import com.jobsity.bowlingscoreboard.domain.model.Game;

public class PlayerGameBoardOutput {
	
	private static final String SPARE = "/";
	private static final String STRIKE = "X";
	
	private Game game;
	
	public PlayerGameBoardOutput(Game game) {
		this.game = game;
	}
	
	@Override
	public String toString() {
		StringBuilder formatted = new StringBuilder();
		List<Frame> frames = this.game.getFrames();
		
		formatted.append(this.game.getPlayer());
		formatted.append(ConsoleGameBoardsOutput.RETURN);
		formatted.append("Pinfalls" + ConsoleGameBoardsOutput.TAB);
		
		int frameCount = 1;
		int total = 0;
		StringBuilder frameLine = new StringBuilder();
		StringBuilder scoreLine = new StringBuilder();
		for (Frame frame : frames) {
			total += frame.getScore();
			if (frameCount < 10) {
				if (frame.hadStrike()) {
					frameLine.append(ConsoleGameBoardsOutput.TAB + STRIKE + ConsoleGameBoardsOutput.TAB);
				}
				if (frame.hadSpare()) {
					frameLine.append(frame.getFirstRoll().getPinsDown() + ConsoleGameBoardsOutput.TAB + SPARE + ConsoleGameBoardsOutput.TAB);
				}
				if (frame.hadNoBonus()) {
					frameLine.append(frame.getFirstRoll().getPinsDown() + ConsoleGameBoardsOutput.TAB + frame.getSecondRoll().getPinsDown() + ConsoleGameBoardsOutput.TAB);
				}
				scoreLine.append(total + ConsoleGameBoardsOutput.TAB + ConsoleGameBoardsOutput.TAB);
			}
			if (frameCount == 10) {
				if (frame.getThirdRoll() != null) {
					String lastRoll = frame.getFirstRoll().getPinsDown() + ConsoleGameBoardsOutput.TAB + frame.getSecondRoll().getPinsDown() + ConsoleGameBoardsOutput.TAB + frame.getThirdRoll().getPinsDown();
					frameLine.append(lastRoll.replace("10", STRIKE));
				}
				scoreLine.append(total);
			}
			frameCount++;
		}
		
		formatted.append(frameLine + ConsoleGameBoardsOutput.RETURN);
		formatted.append("Score" + ConsoleGameBoardsOutput.TAB + ConsoleGameBoardsOutput.TAB);
		formatted.append(scoreLine + ConsoleGameBoardsOutput.RETURN);
		return formatted.toString();
	}

}
