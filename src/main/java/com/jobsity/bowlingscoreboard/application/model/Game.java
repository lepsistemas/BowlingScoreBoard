package com.jobsity.bowlingscoreboard.application.model;

import static java.util.Arrays.asList;

import java.util.List;

import com.jobsity.bowlingscoreboard.domain.model.Roll;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString(exclude = { "currentFrame" })
public class Game {
	
	private String player;
	private Frame[] frames;
	private int currentFrame;
	
	public Game(String player) {
		this.player = player;
		this.frames = new Frame[10];
		this.currentFrame = 0;
	}

	public void roll(Roll roll) {
		System.out.println("Roll " + roll.getPinsDown());
		Frame frame = this.getCurrentFrame();
		frame.addRoll(roll);
		this.frames[this.currentFrame] = frame;
		System.out.println(this.currentFrame + ": " + frame);
	}

	private Frame getCurrentFrame() {
		Frame frame = this.frames[this.currentFrame];
		if (frame == null) {
			return new Frame();
		}
		if (frame.isEnded()) {
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
			gameScore += frame == null ? 0 : frame.getScore();
		}
		return gameScore;
	}
	
	public List<Frame> getFrames() {
		return asList(this.frames);
	}

}
