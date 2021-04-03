package com.jobsity.bowlingscoreboard.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.jobsity.bowlingscoreboard.application.game.TenPinBowlingGame;
import com.jobsity.bowlingscoreboard.application.io.Input;
import com.jobsity.bowlingscoreboard.application.io.Output;
import com.jobsity.bowlingscoreboard.domain.usecase.BowlingGameScoreCalculation;

public class GameFactoryTest {
	
	@Test
	public void shouldCreateDefaultBoard() {
		GameFactory factory = new GameFactory() {
			
			@Override
			public Output output() {
				return null;
			}
			
			@Override
			public Input input() {
				return null;
			}
			
			@Override
			public BowlingGameScoreCalculation calculation() {
				return null;
			}
		};
		
		assertThat(factory.game()).isExactlyInstanceOf(TenPinBowlingGame.class);
	}

}
