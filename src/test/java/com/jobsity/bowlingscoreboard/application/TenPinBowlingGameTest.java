package com.jobsity.bowlingscoreboard.application;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jobsity.bowlingscoreboard.application.usecase.BowlingGameScoreCalculation;
import com.jobsity.bowlingscoreboard.domain.model.Roll;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.dto.RollInput;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

@ExtendWith(MockitoExtension.class)
public class TenPinBowlingGameTest {
	
	private BowlingGameDependencies dependencies;
	
	private TenPinBowlingGame board;

	@Mock
	private Output output;

	@Mock
	private Input input;

	@Mock
	private BowlingGameScoreCalculation calculation;
	
	@BeforeEach
	public void setUp() {
		this.dependencies = new BowlingGameDependencies(this.output, this.input, this.calculation);
		this.board = new TenPinBowlingGame(this.dependencies);
	}
	
	@Test
	@Disabled
	public void shouldCalculateGameScore() {
		ScoreTableInput scoreTableInput = new ScoreTableInput("Player");
		scoreTableInput.addRoll(new RollInput("10"));
		when(this.input.read()).thenReturn(asList(scoreTableInput));
		
		this.board.start();
		
		ScoreTable scoreTable = new ScoreTable("Player");
		scoreTable.addRoll(new Roll(10));
		verify(this.calculation).calculate(scoreTable);
	}

}
