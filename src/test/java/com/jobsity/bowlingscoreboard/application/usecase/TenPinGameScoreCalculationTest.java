package com.jobsity.bowlingscoreboard.application.usecase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.domain.model.GameBoard;
import com.jobsity.bowlingscoreboard.domain.model.Roll;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;

public class TenPinGameScoreCalculationTest {
	
	private BowlingGameScoreCalculation calculation;
	
	@BeforeEach
	public void setUp() {
		this.calculation = new TenPinGameScoreCalculation();
	}
	
	@Test
	public void shouldCalculateZeroGameScore() {
		ScoreTable table = zeroScoreTable();
		GameBoard gameScore = this.calculation.calculate(table);
		
		GameBoard expected = expectedZeroGameScore();
		assertThat(gameScore).isEqualTo(expected);
	}
	
	/*@Test
	public void shouldCalculateGameScore() {
		ScoreTable table = ordinaryScoreTable();
		GameScore gameScore = this.calculation.calculate(table);
		
		GameScore expected = expectedGameScore();
		assertThat(gameScore).isEqualTo(expected);
	}

	private GameScore expectedGameScore() {
		GameScore gameScore = new GameScore();
		gameScore.addRoll(new Roll("Jeff", 10));
		gameScore.addRoll(new Roll("John", 3));
		gameScore.addRoll(new Roll("John", 7));
		gameScore.addRoll(new Roll("Jeff", 7));
		gameScore.addRoll(new Roll("Jeff", 3));
		gameScore.addRoll(new Roll("John", 6));
		gameScore.addRoll(new Roll("John", 3));
		gameScore.addRoll(new Roll("Jeff", 9));
		gameScore.addRoll(new Roll("Jeff", 0));
		gameScore.addRoll(new Roll("John", 10));
		gameScore.addRoll(new Roll("Jeff", 10));
		gameScore.addRoll(new Roll("John", 8));
		gameScore.addRoll(new Roll("John", 1));
		gameScore.addRoll(new Roll("Jeff", 0));
		gameScore.addRoll(new Roll("Jeff", 8));
		gameScore.addRoll(new Roll("John", 10));
		gameScore.addRoll(new Roll("Jeff", 8));
		gameScore.addRoll(new Roll("Jeff", 2));
		gameScore.addRoll(new Roll("John", 10));
		gameScore.addRoll(new Roll("Jeff", 0));
		gameScore.addRoll(new Roll("Jeff", 6));
		gameScore.addRoll(new Roll("John", 9));
		gameScore.addRoll(new Roll("John", 0));
		gameScore.addRoll(new Roll("Jeff", 10));
		gameScore.addRoll(new Roll("John", 7));
		gameScore.addRoll(new Roll("John", 3));
		gameScore.addRoll(new Roll("Jeff", 10));
		gameScore.addRoll(new Roll("John", 4));
		gameScore.addRoll(new Roll("John", 4));
		gameScore.addRoll(new Roll("Jeff", 10));
		gameScore.addRoll(new Roll("Jeff", 8));
		gameScore.addRoll(new Roll("Jeff", 1));
		gameScore.addRoll(new Roll("John", 10));
		gameScore.addRoll(new Roll("John", 9));
		gameScore.addRoll(new Roll("John", 0));
		return gameScore;
	}

	private ScoreTable ordinaryScoreTable() {
		ScoreTable scoreTable = new ScoreTable();
		scoreTable.addRoll(new Roll("Jeff", 10));
		scoreTable.addRoll(new Roll("John", 3));
		scoreTable.addRoll(new Roll("John", 7));
		scoreTable.addRoll(new Roll("Jeff", 7));
		scoreTable.addRoll(new Roll("Jeff", 3));
		scoreTable.addRoll(new Roll("John", 6));
		scoreTable.addRoll(new Roll("John", 3));
		scoreTable.addRoll(new Roll("Jeff", 9));
		scoreTable.addRoll(new Roll("Jeff", 0));
		scoreTable.addRoll(new Roll("John", 10));
		scoreTable.addRoll(new Roll("Jeff", 10));
		scoreTable.addRoll(new Roll("John", 8));
		scoreTable.addRoll(new Roll("John", 1));
		scoreTable.addRoll(new Roll("Jeff", 0));
		scoreTable.addRoll(new Roll("Jeff", 8));
		scoreTable.addRoll(new Roll("John", 10));
		scoreTable.addRoll(new Roll("Jeff", 8));
		scoreTable.addRoll(new Roll("Jeff", 2));
		scoreTable.addRoll(new Roll("John", 10));
		scoreTable.addRoll(new Roll("Jeff", 0));
		scoreTable.addRoll(new Roll("Jeff", 6));
		scoreTable.addRoll(new Roll("John", 9));
		scoreTable.addRoll(new Roll("John", 0));
		scoreTable.addRoll(new Roll("Jeff", 10));
		scoreTable.addRoll(new Roll("John", 7));
		scoreTable.addRoll(new Roll("John", 3));
		scoreTable.addRoll(new Roll("Jeff", 10));
		scoreTable.addRoll(new Roll("John", 4));
		scoreTable.addRoll(new Roll("John", 4));
		scoreTable.addRoll(new Roll("Jeff", 10));
		scoreTable.addRoll(new Roll("Jeff", 8));
		scoreTable.addRoll(new Roll("Jeff", 1));
		scoreTable.addRoll(new Roll("John", 10));
		scoreTable.addRoll(new Roll("John", 9));
		scoreTable.addRoll(new Roll("John", 0));
		return scoreTable;
	}*/
	
	private ScoreTable zeroScoreTable() {
		ScoreTable scoreTable = new ScoreTable("Player");
		for(int i = 0; i < 10; i++) {
			scoreTable.addRoll(new Roll(0));
			scoreTable.addRoll(new Roll(0));
		}
		return scoreTable;
	}
	
	private GameBoard expectedZeroGameScore() {
		GameBoard gameScore = new GameBoard("Player");
		for(int i = 0; i < 10; i++) {
		}
		return gameScore;
	}

}
