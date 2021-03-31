package com.jobsity.bowlingscoreboard.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Roll {
	
	private String player;
	private Integer pindsDown;

	public Roll(String player, Integer pindsDown) {
		this.player = player;
		this.pindsDown = pindsDown;
	}

}
