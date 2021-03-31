package com.jobsity.bowlingscoreboard.application.model;

import static java.util.Arrays.asList;

import java.util.List;

import com.jobsity.bowlingscoreboard.domain.model.Roll;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(exclude = { "currentFrame", "previousFrameWithStrike", "previousFrameWithSpare" })
@ToString(exclude = { "currentFrame", "previousFrameWithStrike", "previousFrameWithSpare" })
public class Game {
	
	private String player;
	private Frame[] frames;
	private Integer currentFrame;
	private Frame previousFrameWithStrike;
	private Frame previousFrameWithSpare;
	
	public Game(String player) {
		this.player = player;
		this.frames = new Frame[10];
		this.currentFrame = 0;
		this.previousFrameWithStrike = null;
	}

	public void roll(Roll roll) {
		Frame frame = this.getCurrentFrame();
		dealWithoutBonus(roll, frame);
		dealWithStrike(frame);
		dealWithSpare(frame);
	}

	private void dealWithoutBonus(Roll roll, Frame frame) {
		frame.addRoll(roll);
		this.frames[this.currentFrame] = frame;
	}

	private void dealWithSpare(Frame frame) {
		if (this.previousFrameWithSpare != null) {
			addSpareBonus(frame);
		}
		if (frame.madeSpare()) {
			this.previousFrameWithSpare = frame;
		}
	}

	private void dealWithStrike(Frame frame) {
		if (this.previousFrameWithStrike != null) {
			addStrikeBonus(frame);
		}
		if (frame.madeStrike()) {
			this.previousFrameWithStrike = frame;
		}
	}

	private void addStrikeBonus(Frame frame) {
		this.previousFrameWithStrike.addBonus(frame.getScore());
		if (frame.isOver()) {
			this.previousFrameWithStrike = null;
		}
	}
	
	private void addSpareBonus(Frame frame) {
		this.previousFrameWithSpare.addBonus(frame.getFirstRoll().getPinsDown());
		if (frame.isOver()) {
			this.previousFrameWithSpare = null;
		}
	}

	private Frame getCurrentFrame() {
		Frame frame = this.frames[this.currentFrame];
		if (frame == null) {
			return new Frame();
		}
		if (frame.isOver()) {
			frame = new Frame();
			this.currentFrame++;
		}
		return frame;
	}
	
	public String getPlayer() {
		return this.player;
	}

	public int getTotalScore() {
		int gameScore = 0;
		for(Frame frame : this.frames) {
			int bonus = 0;
			gameScore += frame.getScore() + bonus;
		}
		return gameScore;
	}
	
	public List<Frame> getFrames() {
		return asList(this.frames);
	}

}
