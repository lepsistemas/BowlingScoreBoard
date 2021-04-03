package com.jobsity.bowlingscoreboard.domain.model;

import static java.util.Arrays.asList;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(exclude = { "currentFrame" })
@ToString(exclude = { "currentFrame" })
public class Game {
	
	private static final int MAX_FRAMES_IN_GAME = 10;
	private static final int INITIAL_CURRENT_FRAME = 0;
	
	private String player;
	private Frame[] frames;
	private Integer currentFrame;
	
	public Game(String player) {
		this.player = player;
		this.frames = new Frame[MAX_FRAMES_IN_GAME];
		this.currentFrame = INITIAL_CURRENT_FRAME;
	}

	public void roll(Roll roll) {
		if (this.currentFrame < MAX_FRAMES_IN_GAME) {
			Frame frame = this.getCurrentFrame();
			dealWithoutBonus(roll, frame);
			dealWithStrike();
			dealWithSpare();
			if (frame.isOver() && !isLastFrame()) {
				this.currentFrame++;
			}
		}
	}

	private void dealWithoutBonus(Roll roll, Frame frame) {
		frame.addRoll(roll);
		this.frames[this.currentFrame] = frame;
	}

	private void dealWithSpare() {
		if (this.currentFrame > 0) {
			Frame frame = this.frames[this.currentFrame];
			Frame previousFrame = this.frames[this.currentFrame - 1];
			if (previousFrame.hadSpare()) {
				previousFrame.addBonus(frame.getFirstRoll().getPinsDown());
			}
		}
	}

	private void dealWithStrike() {
		if (this.currentFrame > 1) {
			for(int frameIndex = this.currentFrame; frameIndex > (this.currentFrame - 1); frameIndex--) {
				dealWithBeforePreviousStrike(frameIndex);
				dealWithPreviousStrike(frameIndex);
			}
		}
	}

	private void dealWithPreviousStrike(int frameIndex) {
		Frame frame = this.frames[frameIndex];
		Frame previousFrame = this.frames[frameIndex - 1];
		if (previousFrame.hadStrike()) {
			if (frame.isOver()) {
				previousFrame.addBonus(frame.getRawScore());
			}
		}
	}

	private void dealWithBeforePreviousStrike(int i) {
		Frame frame = this.frames[i];
		Frame previousFrame = this.frames[i - 1];
		Frame beforePreviousFrame = this.frames[i - 2];
		
		if (beforePreviousFrame.hadStrike()) {
			if (previousFrame.hadStrike()) {
				beforePreviousFrame.addBonus(previousFrame.getRawScore() + frame.getFirstRoll().getPinsDown());
			} else {
				beforePreviousFrame.addBonus(previousFrame.getRawScore());
			}
		}
	}

	private Frame getCurrentFrame() {
		Frame frame = this.frames[this.currentFrame];
		if (frame == null) {
			return new Frame();
		}
		if (!isLastFrame() && frame.isOver()) {
			frame = new Frame();
		}
		return frame;
	}

	private boolean isLastFrame() {
		return (this.currentFrame + 1) == MAX_FRAMES_IN_GAME;
	}
	
	public String getPlayer() {
		return this.player;
	}

	public int getTotalScore() {
		int gameScore = 0;
		for(Frame frame : this.frames) {
			gameScore += frame.getScore();
		}
		return gameScore;
	}
	
	public List<Frame> getFrames() {
		return asList(this.frames);
	}

}
