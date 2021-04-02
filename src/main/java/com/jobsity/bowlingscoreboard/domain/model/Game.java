package com.jobsity.bowlingscoreboard.domain.model;

import static java.util.Arrays.asList;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(exclude = { "currentFrame" })
@ToString(exclude = { "currentFrame" })
public class Game {
	
	private String player;
	private Frame[] frames;
	private Integer currentFrame;
	
	public Game(String player) {
		this.player = player;
		this.frames = new Frame[10];
		this.currentFrame = 0;
	}

	public void roll(Roll roll) {
		if (this.currentFrame < 10) {
			Frame frame = this.getCurrentFrame();
			dealWithoutBonus(roll, frame);
			dealWithStrike(this.currentFrame);
			dealWithSpare(this.currentFrame);
			if (frame.isOver() && !isLastFrame()) {
				this.currentFrame++;
			}
		}
	}

	private void dealWithoutBonus(Roll roll, Frame frame) {
		frame.addRoll(roll);
		this.frames[this.currentFrame] = frame;
	}

	private void dealWithSpare(int frameIndex) {
		if (frameIndex > 0) {
			Frame frame = this.frames[this.currentFrame];
			Frame previousFrame = this.frames[frameIndex - 1];
			if (previousFrame.hadSpare()) {
				previousFrame.addBonus(frame.getFirstRoll().getPinsDown());
			}
		}
	}

	private void dealWithStrike(int frameIndex) {
		if (frameIndex > 1) {
			Frame previousFrame = this.frames[frameIndex - 1];
			if (previousFrame.hadStrike()) {
				dealWithStrike(frameIndex - 1);
			}
		}
		if (frameIndex > 0) {
			Frame frame = this.frames[this.currentFrame];
			Frame previousFrame = this.frames[frameIndex - 1];
			if (previousFrame.hadStrike()) {
				if (!frame.hadStrike() && frame.isOver()) {
					previousFrame.addBonus(frame.getFirstRoll().getPinsDown() + frame.getSecondRoll().getPinsDown());
				}
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
		return (this.currentFrame + 1) == 10;
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
