package com.jobsity.bowlingscoreboard.infrastructure.console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jobsity.bowlingscoreboard.domain.model.Game;
import com.jobsity.bowlingscoreboard.infrastructure.dto.GameBoardsOutput;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ConsoleGameBoardsOutput implements GameBoardsOutput {
	
	protected static final String TAB = "	";
	protected static final String RETURN = System.getProperty("line.separator");
	
	private ConsoleFramesGameBoardOutput frame;
	private List<ConsolePlayerGameBoardOutput> players;
	
	public ConsoleGameBoardsOutput(List<Game> games) {
		this.frame = new ConsoleFramesGameBoardOutput();
		this.players = new ArrayList<>();
		for (Game game : games) {
			this.players.add(new ConsolePlayerGameBoardOutput(game));
		}
	}
	
	@Override
	public String toString() {
		return this.frame.toString() 
				+ this.players.stream()
					.map(player -> player.toString())
					.collect(Collectors.joining());
	}
	
}
