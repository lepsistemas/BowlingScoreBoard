package com.jobsity.bowlingscoreboard.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
	
	private Game game;
	
	@BeforeEach
	public void setUp() {
		this.game = new Game("Player");
	}

	@Test
	public void shouldCreateZeroedGame() {
		roll(new int[] { 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0 });
		
		assertThat(this.game.getPlayer()).isEqualTo("Player");
		assertThat(this.game.getFrames().get(0).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(0).getScore()).isEqualTo(0);
		assertThat(this.game.getFrames().get(1).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(1).getScore()).isEqualTo(0);
		assertThat(this.game.getFrames().get(2).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(2).getScore()).isEqualTo(0);
		assertThat(this.game.getFrames().get(3).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(3).getScore()).isEqualTo(0);
		assertThat(this.game.getFrames().get(4).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(4).getScore()).isEqualTo(0);
		assertThat(this.game.getFrames().get(5).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(5).getScore()).isEqualTo(0);
		assertThat(this.game.getFrames().get(6).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(6).getScore()).isEqualTo(0);
		assertThat(this.game.getFrames().get(7).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(7).getScore()).isEqualTo(0);
		assertThat(this.game.getFrames().get(8).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(8).getScore()).isEqualTo(0);
		assertThat(this.game.getFrames().get(9).getRolls().size()).isEqualTo(2);
		assertThat(this.game.getFrames().get(9).getScore()).isEqualTo(0);
		assertThat(this.game.getTotalScore()).isEqualTo(0);
	}
	
	@Test
	public void shouldCreateGameWithoutBonus() {
		roll(new int[] { 1,2, 3,4, 1,2, 3,4, 1,2, 3,4, 1,2, 3,4, 1,2, 3,4 });
		
		assertThat(this.game.getPlayer()).isEqualTo("Player");
		assertThat((this.game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(0)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(1)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(2)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(3)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(4)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(5)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(6)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(7)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(8)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(9)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(9)).getScore()).isEqualTo(7);
		assertThat(this.game.getTotalScore()).isEqualTo(50);
	}
	
	@Test
	public void shouldCreateGameWithStrike() {
		roll(new int[] { 10, 1,2, 3,4, 10, 1,2, 3,4, 10, 1,2, 3,4, 1,1 });
		
		assertThat(this.game.getPlayer()).isEqualTo("Player");
		assertThat((this.game.getFrames().get(0)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(0)).getScore()).isEqualTo(13);
		assertThat((this.game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(1)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(2)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(3)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(3)).getScore()).isEqualTo(13);
		assertThat((this.game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(4)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(5)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(6)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(6)).getScore()).isEqualTo(13);
		assertThat((this.game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(7)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(8)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(9)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(9)).getScore()).isEqualTo(2);
		assertThat(this.game.getTotalScore()).isEqualTo(71);
	}
	
	@Test
	public void shouldCreateGameWithSpare() {
		roll(new int[] { 1,9, 3,4, 1,2, 3,7, 1,2, 3,4, 1,2, 3,4, 1,2, 3,4 });
		
		assertThat(this.game.getPlayer()).isEqualTo("Player");
		assertThat((this.game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(0)).getScore()).isEqualTo(13);
		assertThat((this.game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(1)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(2)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(3)).getScore()).isEqualTo(11);
		assertThat((this.game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(4)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(5)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(6)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(7)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(8)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(9)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(9)).getScore()).isEqualTo(7);
		assertThat(this.game.getTotalScore()).isEqualTo(64);
	}
	
	@Test
	public void shouldCreateGameWithStrikeAndSpare() {
		roll(new int[] { 1,9, 3,4, 10, 3,7, 10, 3,4, 1,2, 3,4, 1,2, 3,4 });
		
		assertThat(this.game.getPlayer()).isEqualTo("Player");
		assertThat((this.game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(0)).getScore()).isEqualTo(13);
		assertThat((this.game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(1)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(2)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(2)).getScore()).isEqualTo(20);
		assertThat((this.game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(3)).getScore()).isEqualTo(20);
		assertThat((this.game.getFrames().get(4)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(4)).getScore()).isEqualTo(17);
		assertThat((this.game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(5)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(6)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(7)).getScore()).isEqualTo(7);
		assertThat((this.game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(8)).getScore()).isEqualTo(3);
		assertThat((this.game.getFrames().get(9)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(9)).getScore()).isEqualTo(7);
		assertThat(this.game.getTotalScore()).isEqualTo(104);
	}
	
	@Test
	public void shouldCreateGameWithStrikeAtLastFrame() {
		roll(new int[] { 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 10,9,1 });
		
		assertThat(this.game.getPlayer()).isEqualTo("Player");
		assertThat((this.game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(0)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(1)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(2)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(3)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(4)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(5)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(6)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(7)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(8)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(9)).getRolls().size()).isEqualTo(3);
		assertThat((this.game.getFrames().get(9)).getScore()).isEqualTo(20);
		assertThat(this.game.getTotalScore()).isEqualTo(38);
	}
	
	@Test
	public void shouldCreateGameWithSpareAtLastFrame() {
		roll(new int[] { 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 2,8,5 });
		
		assertThat(this.game.getPlayer()).isEqualTo("Player");
		assertThat((this.game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(0)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(1)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(2)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(3)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(4)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(5)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(6)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(7)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(8)).getScore()).isEqualTo(2);
		assertThat((this.game.getFrames().get(9)).getRolls().size()).isEqualTo(3);
		assertThat((this.game.getFrames().get(9)).getScore()).isEqualTo(15);
		assertThat(this.game.getTotalScore()).isEqualTo(33);
	}
	
	@Test
	public void shouldCreatePerfectGame() {
		roll(new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 });
		
		assertThat(this.game.getPlayer()).isEqualTo("Player");
		assertThat((this.game.getFrames().get(0)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(0)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(1)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(1)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(2)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(2)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(3)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(3)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(4)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(4)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(5)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(5)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(6)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(6)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(7)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(7)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(8)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(8)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(9)).getRolls().size()).isEqualTo(3);
		assertThat((this.game.getFrames().get(9)).getScore()).isEqualTo(30);
		assertThat(this.game.getTotalScore()).isEqualTo(300);
	}

	private void roll(int[] rolls) {
		for(int roll: rolls) {
			this.game.roll(new Roll(roll));
		}
	}

}
