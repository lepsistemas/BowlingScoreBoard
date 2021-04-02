package com.jobsity.bowlingscoreboard.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GameTest {
	
	@Test
	public void shouldCreateZeroedGame() {
		Game game = new Game("Player");
		
		for(int i = 0; i < 10; i++) {
			game.roll(new Roll(0));
			game.roll(new Roll(0));
		}
		
		assertThat(game.getPlayer()).isEqualTo("Player");
		assertThat(game.getFrames().get(0).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(0).getScore()).isEqualTo(0);
		assertThat(game.getFrames().get(1).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(1).getScore()).isEqualTo(0);
		assertThat(game.getFrames().get(2).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(2).getScore()).isEqualTo(0);
		assertThat(game.getFrames().get(3).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(3).getScore()).isEqualTo(0);
		assertThat(game.getFrames().get(4).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(4).getScore()).isEqualTo(0);
		assertThat(game.getFrames().get(5).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(5).getScore()).isEqualTo(0);
		assertThat(game.getFrames().get(6).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(6).getScore()).isEqualTo(0);
		assertThat(game.getFrames().get(7).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(7).getScore()).isEqualTo(0);
		assertThat(game.getFrames().get(8).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(8).getScore()).isEqualTo(0);
		assertThat(game.getFrames().get(9).getRolls().size()).isEqualTo(2);
		assertThat(game.getFrames().get(9).getScore()).isEqualTo(0);
		assertThat(game.getTotalScore()).isEqualTo(0);
	}
	
	@Test
	public void shouldCreateGameWithoutBonus() {
		Game game = new Game("Player");
		
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		
		assertThat(game.getPlayer()).isEqualTo("Player");
		assertThat((game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(0)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(1)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(2)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(3)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(4)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(5)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(6)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(7)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(8)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(9)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(9)).getScore()).isEqualTo(7);
		assertThat(game.getTotalScore()).isEqualTo(50);
	}
	
	@Test
	public void shouldCreateGameWithStrike() {
		Game game = new Game("Player");
		
		game.roll(new Roll(10));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(10));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(10));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		
		assertThat(game.getPlayer()).isEqualTo("Player");
		assertThat((game.getFrames().get(0)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(0)).getScore()).isEqualTo(13);
		assertThat((game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(1)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(2)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(3)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(3)).getScore()).isEqualTo(13);
		assertThat((game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(4)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(5)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(6)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(6)).getScore()).isEqualTo(13);
		assertThat((game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(7)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(8)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(9)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(9)).getScore()).isEqualTo(2);
		assertThat(game.getTotalScore()).isEqualTo(71);
	}
	
	@Test
	public void shouldCreateGameWithSpare() {
		Game game = new Game("Player");
		
		game.roll(new Roll(1));
		game.roll(new Roll(9));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(7));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		
		assertThat(game.getPlayer()).isEqualTo("Player");
		assertThat((game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(0)).getScore()).isEqualTo(13);
		assertThat((game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(1)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(2)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(3)).getScore()).isEqualTo(11);
		assertThat((game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(4)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(5)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(6)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(7)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(8)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(9)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(9)).getScore()).isEqualTo(7);
		assertThat(game.getTotalScore()).isEqualTo(64);
	}
	
	@Test
	public void shouldCreateGameWithStrikeAndSpare() {
		Game game = new Game("Player");
		
		game.roll(new Roll(1));
		game.roll(new Roll(9));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(10));
		game.roll(new Roll(3));
		game.roll(new Roll(7));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(3));
		game.roll(new Roll(4));
		
		assertThat(game.getPlayer()).isEqualTo("Player");
		assertThat((game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(0)).getScore()).isEqualTo(13);
		assertThat((game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(1)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(2)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(2)).getScore()).isEqualTo(20);
		assertThat((game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(3)).getScore()).isEqualTo(11);
		assertThat((game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(4)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(5)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(6)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(7)).getScore()).isEqualTo(7);
		assertThat((game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(8)).getScore()).isEqualTo(3);
		assertThat((game.getFrames().get(9)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(9)).getScore()).isEqualTo(7);
		assertThat(game.getTotalScore()).isEqualTo(81);
	}
	
	@Test
	public void shouldCreateGameWithStrikeAtLastFrame() {
		Game game = new Game("Player");
		
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(10));
		game.roll(new Roll(9));
		game.roll(new Roll(0));
		
		assertThat(game.getPlayer()).isEqualTo("Player");
		assertThat((game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(0)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(1)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(2)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(3)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(4)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(5)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(6)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(7)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(8)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(9)).getRolls().size()).isEqualTo(3);
		assertThat((game.getFrames().get(9)).getScore()).isEqualTo(19);
		assertThat(game.getTotalScore()).isEqualTo(37);
	}
	
	@Test
	public void shouldCreateGameWithSpareAtLastFrame() {
		Game game = new Game("Player");
		
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(1));
		game.roll(new Roll(2));
		game.roll(new Roll(8));
		game.roll(new Roll(5));
		
		assertThat(game.getPlayer()).isEqualTo("Player");
		assertThat((game.getFrames().get(0)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(0)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(1)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(1)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(2)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(2)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(3)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(3)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(4)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(4)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(5)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(5)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(6)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(6)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(7)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(7)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(8)).getRolls().size()).isEqualTo(2);
		assertThat((game.getFrames().get(8)).getScore()).isEqualTo(2);
		assertThat((game.getFrames().get(9)).getRolls().size()).isEqualTo(3);
		assertThat((game.getFrames().get(9)).getScore()).isEqualTo(15);
		assertThat(game.getTotalScore()).isEqualTo(33);
	}
	
	@Test
	@Disabled
	public void shouldCreatePerfectGame() {
		Game game = new Game("Player");
		
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		game.roll(new Roll(10));
		
		assertThat(game.getPlayer()).isEqualTo("Player");
		assertThat((game.getFrames().get(0)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(0)).getScore()).isEqualTo(30);
		assertThat((game.getFrames().get(1)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(1)).getScore()).isEqualTo(30);
		assertThat((game.getFrames().get(2)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(2)).getScore()).isEqualTo(30);
		assertThat((game.getFrames().get(3)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(3)).getScore()).isEqualTo(30);
		assertThat((game.getFrames().get(4)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(4)).getScore()).isEqualTo(30);
		assertThat((game.getFrames().get(5)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(5)).getScore()).isEqualTo(30);
		assertThat((game.getFrames().get(6)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(6)).getScore()).isEqualTo(30);
		assertThat((game.getFrames().get(7)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(7)).getScore()).isEqualTo(30);
		assertThat((game.getFrames().get(8)).getRolls().size()).isEqualTo(1);
		assertThat((game.getFrames().get(8)).getScore()).isEqualTo(30);
		assertThat((game.getFrames().get(9)).getRolls().size()).isEqualTo(3);
		assertThat((game.getFrames().get(9)).getScore()).isEqualTo(30);
		assertThat(game.getTotalScore()).isEqualTo(300);
	}

}
