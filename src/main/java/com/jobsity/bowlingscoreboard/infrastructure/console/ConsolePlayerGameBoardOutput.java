package com.jobsity.bowlingscoreboard.infrastructure.console;

import java.util.List;

import com.jobsity.bowlingscoreboard.domain.model.Frame;
import com.jobsity.bowlingscoreboard.domain.model.Game;

public class ConsolePlayerGameBoardOutput {
	
	private static final String SPARE = "/";
	private static final String STRIKE = "X";
	
	private Game game;
	
	public ConsolePlayerGameBoardOutput(Game game) {
		this.game = game;
	}
	
	@Override
	public String toString() {
		StringBuilder formatted = new StringBuilder();
		appendHeader(formatted);
		
		int frameCount = 1;
		int total = 0;
		StringBuilder frameLine = new StringBuilder();
		StringBuilder scoreLine = new StringBuilder();
		for (Frame frame : this.game.getFrames()) {
			total += frame.getScore();
			appendInitialRounds(frameCount, total, frameLine, scoreLine, frame);
			appendLastRound(frameCount, total, frameLine, scoreLine, frame);
			frameCount++;
		}
		
		appendTotalScore(formatted, frameLine, scoreLine);
		return formatted.toString();
	}

	private void appendTotalScore(StringBuilder formatted, StringBuilder frameLine, StringBuilder scoreLine) {
		formatted.append(frameLine + ConsoleGameBoardsOutput.RETURN);
		formatted.append("Score" + ConsoleGameBoardsOutput.TAB + ConsoleGameBoardsOutput.TAB);
		formatted.append(scoreLine + ConsoleGameBoardsOutput.RETURN);
	}

	private void appendHeader(StringBuilder formatted) {
		formatted.append(this.game.getPlayer());
		formatted.append(ConsoleGameBoardsOutput.RETURN);
		formatted.append("Pinfalls" + ConsoleGameBoardsOutput.TAB);
	}

	private void appendLastRound(int frameCount, int total, StringBuilder frameLine, StringBuilder scoreLine,
			Frame frame) {
		if (frameCount == 10) {
			String firstRollPinsDown = frame.getFirstRoll().getPinsDown() != null ? frame.getFirstRoll().getPinsDown().toString() : "F";
			String secondRollPinsDown = frame.getSecondRoll().getPinsDown() != null ? frame.getSecondRoll().getPinsDown().toString() : "F";
			String lastRoll = firstRollPinsDown + ConsoleGameBoardsOutput.TAB + secondRollPinsDown;
			if (frame.hasThirdRoll()) {
				String thirdRollPinsDown = frame.getThirdRoll().getPinsDown() != null ? frame.getThirdRoll().getPinsDown().toString() : "F";
				lastRoll += ConsoleGameBoardsOutput.TAB + thirdRollPinsDown;
			}
			frameLine.append(lastRoll.replace("10", STRIKE));
			scoreLine.append(total);
		}
	}

	private void appendInitialRounds(int frameCount, int total, StringBuilder frameLine, StringBuilder scoreLine,
			Frame frame) {
		if (frameCount < 10) {
			if (frame.hadStrike()) {
				frameLine.append(ConsoleGameBoardsOutput.TAB + STRIKE + ConsoleGameBoardsOutput.TAB);
			}
			String firstRollPinsDown = frame.getFirstRoll().getPinsDown() != null ? frame.getFirstRoll().getPinsDown().toString() : "F";
			if (frame.hadSpare()) {
				frameLine.append(firstRollPinsDown + ConsoleGameBoardsOutput.TAB + SPARE + ConsoleGameBoardsOutput.TAB);
			}
			if (frame.hadNoBonus()) {
				String secondRollPinsDown = frame.getSecondRoll().getPinsDown() != null ? frame.getSecondRoll().getPinsDown().toString() : "F";
				frameLine.append(firstRollPinsDown + ConsoleGameBoardsOutput.TAB + secondRollPinsDown + ConsoleGameBoardsOutput.TAB);
			}
			scoreLine.append(total + ConsoleGameBoardsOutput.TAB + ConsoleGameBoardsOutput.TAB);
		}
	}

}
