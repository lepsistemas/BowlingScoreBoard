package com.jobsity.bowlingscoreboard.domain.usecase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.domain.model.Game;
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
		Game gameScore = this.calculation.calculate(table);
		
		Game expected = expectedZeroGameScore();
		assertThat(gameScore).isEqualTo(expected);
	}
	
	private ScoreTable zeroScoreTable() {
		ScoreTable scoreTable = new ScoreTable("Player");
		for(int i = 0; i < 10; i++) {
			scoreTable.addRoll(new Roll(0));
			scoreTable.addRoll(new Roll(0));
		}
		return scoreTable;
	}
	
	private Game expectedZeroGameScore() {
		Game game = new Game("Player");
		for(int i = 0; i < 10; i++) {
			game.roll(new Roll(0));
			game.roll(new Roll(0));
		}
		return game;
	}

}
