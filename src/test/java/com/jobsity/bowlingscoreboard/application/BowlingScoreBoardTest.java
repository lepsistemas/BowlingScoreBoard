package com.jobsity.bowlingscoreboard.application;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jobsity.bowlingscoreboard.application.usecase.GameScoreCalculationPort;
import com.jobsity.bowlingscoreboard.domain.model.Roll;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.dto.RollInput;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

@ExtendWith(MockitoExtension.class)
public class BowlingScoreBoardTest {
	
	private BowlingScoreBoardDependencies dependencies;
	
	private BowlingScoreBoard board;

	@Mock
	private Output output;

	@Mock
	private Input input;

	@Mock
	private GameScoreCalculationPort calculation;
	
	@BeforeEach
	public void setUp() {
		this.dependencies = new BowlingScoreBoardDependencies(this.output, this.input, this.calculation);
		this.board = new BowlingScoreBoard(this.dependencies);
	}
	
	@Test
	public void shouldCalculateGameScore() {
		ScoreTableInput scoreTableInput = new ScoreTableInput();
		scoreTableInput.addRoll(new RollInput("Player", "10"));
		when(this.input.read()).thenReturn(scoreTableInput);
		
		this.board.start();
		
		ScoreTable scoreTable = new ScoreTable();
		scoreTable.addRoll(new Roll("Player", 10));
		verify(this.calculation).calculate(scoreTable);
	}

}
