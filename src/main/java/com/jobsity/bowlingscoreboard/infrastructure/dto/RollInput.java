package com.jobsity.bowlingscoreboard.infrastructure.dto;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class RollInput {
	
	private String player;
	private String pinsDown;
	
	public RollInput(String player, String pinsDown) {
		this.player = player;
		this.pinsDown = pinsDown;
	}

	public String getPlayer() {
		return player;
	}

	public String getPinsDown() {
		return pinsDown;
	}

}
