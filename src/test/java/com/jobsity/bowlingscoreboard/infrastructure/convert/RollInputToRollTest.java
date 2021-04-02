package com.jobsity.bowlingscoreboard.infrastructure.convert;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.domain.model.Roll;
import com.jobsity.bowlingscoreboard.infrastructure.dto.RollInput;

public class RollInputToRollTest {
	
	@Test
	public void shoulConvertFoulRoll() {
		RollInput input = new RollInput("F");
		
		Roll roll = RollInputToRoll.convert(input);
		
		assertThat(roll).isEqualTo(new Roll(null));
	}
	
	@Test
	public void shoulConvertNormalRoll() {
		RollInput input = new RollInput("9");
		
		Roll roll = RollInputToRoll.convert(input);
		
		assertThat(roll).isEqualTo(new Roll(9));
	}

}
