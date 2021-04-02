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
		roll(new Integer[] { 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0 });
		
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
		roll(new Integer[] { 1,2, 3,4, 1,2, 3,4, 1,2, 3,4, 1,2, 3,4, 1,2, 3,4 });
		
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
		roll(new Integer[] { 10, 1,2, 3,4, 10, 1,2, 3,4, 10, 1,2, 3,4, 1,1 });
		
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
		roll(new Integer[] { 1,9, 3,4, 1,2, 3,7, 1,2, 3,4, 1,2, 3,4, 1,2, 3,4 });
		
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
		roll(new Integer[] { 1,9, 3,4, 10, 3,7, 10, 3,4, 1,2, 3,4, 1,2, 3,4 });
		
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
		roll(new Integer[] { 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 10,9,1 });
		
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
		roll(new Integer[] { 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 2,8,5 });
		
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
		roll(new Integer[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 });
		
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
	
	@Test
	public void shouldCreateGameWithFoul() {
		roll(new Integer[] { 10, 7,3, 9,0, 10, 0,8, 8,2, null,6, 10, 10, 10,8,1  });
		
		assertThat(this.game.getPlayer()).isEqualTo("Player");
		assertThat((this.game.getFrames().get(0)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(0)).getScore()).isEqualTo(20);
		assertThat((this.game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(1)).getScore()).isEqualTo(19);
		assertThat((this.game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(2)).getScore()).isEqualTo(9);
		assertThat((this.game.getFrames().get(3)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(3)).getScore()).isEqualTo(18);
		assertThat((this.game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(4)).getScore()).isEqualTo(8);
		assertThat((this.game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(5)).getScore()).isEqualTo(10);
		assertThat((this.game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((this.game.getFrames().get(6)).getScore()).isEqualTo(6);
		assertThat((this.game.getFrames().get(7)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(7)).getScore()).isEqualTo(30);
		assertThat((this.game.getFrames().get(8)).getRolls().size()).isEqualTo(1);
		assertThat((this.game.getFrames().get(8)).getScore()).isEqualTo(28);
		assertThat((this.game.getFrames().get(9)).getRolls().size()).isEqualTo(3);
		assertThat((this.game.getFrames().get(9)).getScore()).isEqualTo(19);
		assertThat(this.game.getTotalScore()).isEqualTo(167);
	}

	private void roll(Integer... rolls) {
		for(Integer roll: rolls) {
			this.game.roll(new Roll(roll));
		}
	}

}
