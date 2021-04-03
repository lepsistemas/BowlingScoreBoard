package com.jobsity.bowlingscoreboard.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FrameTest {
	
	@Test
	public void shouldCreateFrameWithNoBonus() {
		Frame frame = new Frame();
		frame.addRoll(new Roll(1));
		frame.addRoll(new Roll(2));
		
		assertThat(frame.getRawScore()).isEqualTo(3);
		assertThat(frame.getScore()).isEqualTo(3);
		assertThat(frame.getFirstRoll()).isEqualTo(new Roll(1));
		assertThat(frame.getSecondRoll()).isEqualTo(new Roll(2));
		assertThat(frame.getBonus()).isEqualTo(0);
		assertTrue(frame.hadNoBonus());
		assertTrue(frame.isOver());
	}
	
	@Test
	public void shouldCreateStrikeFrameWithBonus() {
		Frame frame = new Frame();
		frame.addRoll(new Roll(10));
		frame.addBonus(5);
		
		assertThat(frame.getRawScore()).isEqualTo(10);
		assertThat(frame.getScore()).isEqualTo(15);
		assertThat(frame.getFirstRoll()).isEqualTo(new Roll(10));
		assertThat(frame.getBonus()).isEqualTo(5);
		assertFalse(frame.hadNoBonus());
		assertTrue(frame.hadStrike());
		assertTrue(frame.isOver());
	}
	
	@Test
	public void shouldCreateSpareFrameWithBonus() {
		Frame frame = new Frame();
		frame.addRoll(new Roll(2));
		frame.addRoll(new Roll(8));
		frame.addBonus(5);
		
		assertThat(frame.getRawScore()).isEqualTo(10);
		assertThat(frame.getScore()).isEqualTo(15);
		assertThat(frame.getFirstRoll()).isEqualTo(new Roll(2));
		assertThat(frame.getSecondRoll()).isEqualTo(new Roll(8));
		assertThat(frame.getBonus()).isEqualTo(5);
		assertFalse(frame.hadNoBonus());
		assertTrue(frame.hadSpare());
		assertTrue(frame.isOver());
	}
	
	@Test
	public void shouldCreateIncompletedFrame() {
		Frame frame = new Frame();
		frame.addRoll(new Roll(2));
		
		assertFalse(frame.isOver());
		assertFalse(frame.hadStrike());
		assertFalse(frame.hadSpare());
	}
	
	@Test
	public void shouldCreateFrameWithFoul() {
		Frame frame = new Frame();
		frame.addRoll(new Roll(null));
		
		assertThat(frame.getRawScore()).isEqualTo(0);
		assertFalse(frame.hadStrike());
		assertFalse(frame.hadSpare());
	}
	
	@Test
	public void shouldCreateFrameWithThirdRoll() {
		Frame frame = new Frame();
		frame.addRoll(new Roll(1));
		frame.addRoll(new Roll(2));
		frame.addRoll(new Roll(3));
		
		assertThat(frame.getThirdRoll()).isEqualTo(new Roll(3));
	}
	
	@Test
	public void shouldCreateZroedFrame() {
		Frame frame = new Frame();
		frame.addRoll(new Roll(0));
		frame.addBonus(null);
		
		assertThat(frame.getRawScore()).isEqualTo(0);
		assertThat(frame.getBonus()).isEqualTo(0);
	}

}
