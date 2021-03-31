package com.jobsity.bowlingscoreboard.infrastructure.convert;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.domain.model.Roll;
import com.jobsity.bowlingscoreboard.domain.model.ScoreTable;
import com.jobsity.bowlingscoreboard.infrastructure.dto.RollInput;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public class ScoreTableInputToScoreTableTest {
	
	@Test
	public void shouldConvertToScoreTable() {
		ScoreTableInput input = new ScoreTableInput("Player");
		input.addRoll(new RollInput("5"));
		input.addRoll(new RollInput("4"));
		
		ScoreTable scoreTable = ScoreTableInputToScoreTable.convert(input);
		
		ScoreTable expected = new ScoreTable("Player");
		expected.addRoll(new Roll(5));
		expected.addRoll(new Roll(4));
		assertThat(scoreTable).isEqualTo(expected);
		// Order guaranteed
		assertThat(scoreTable.getRolls().get(0)).isEqualTo(new Roll(5));
		assertThat(scoreTable.getRolls().get(1)).isEqualTo(new Roll(4));
	}

}
