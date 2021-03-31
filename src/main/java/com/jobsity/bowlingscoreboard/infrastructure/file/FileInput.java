package com.jobsity.bowlingscoreboard.infrastructure.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.jobsity.bowlingscoreboard.application.Input;
import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;
import com.jobsity.bowlingscoreboard.infrastructure.dto.RollInput;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public class FileInput implements Input {

	private static final String TAB = "\\t";
	
	private String path;

	public FileInput(String[] args) {
		this.path = args[0];
	}

	@Override
	public List<ScoreTableInput> read() {
		try {
			Map<String, ScoreTableInput> scoreTables = new LinkedHashMap<>();
			
			Stream<String> lines = Files.lines(Paths.get(this.path));
			lines.forEach(line -> {
	        	Pattern pattern = Pattern.compile(TAB);
	        	Matcher matcher = pattern.matcher(line);
	        	if (matcher.find()) {
	        		int delimitator = matcher.start();
		        	String player = line.substring(0, delimitator);
		        	String pinsDown = line.substring(delimitator + 1);
		        	
		        	
					ScoreTableInput scoreTable = scoreTables.get(player);
					if (scoreTable == null) {
						scoreTable = new ScoreTableInput(player);
					}
		        	scoreTable.addRoll(new RollInput(pinsDown));
		        	scoreTables.put(player, scoreTable);
	        	}
	        });
			lines.close();
			return new ArrayList<>(scoreTables.values());
		} catch (IOException e) {
			throw new InvalidInputFileException("Invalid input file: " + e.getMessage() + ".");
		}
	}

}
