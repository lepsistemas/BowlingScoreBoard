package com.jobsity.bowlingscoreboard.infrastructure.file;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.jobsity.bowlingscoreboard.application.exception.InvalidInputFileException;
import com.jobsity.bowlingscoreboard.application.io.Input;
import com.jobsity.bowlingscoreboard.infrastructure.dto.RollInput;
import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public class JsonInput implements Input {
	
	private String path;
	
	private static final Type SCORE_TABLE_INPUT_TYPE = new TypeToken<List<ScoreTableInput>>() {}.getType();

	public JsonInput(String[] args) {
		this.path = args[0];
	}

	@Override
	public List<ScoreTableInput> read() {
		try {
			Map<String, ScoreTableInput> scoreTables = new LinkedHashMap<>();
			
			GsonBuilder builder = new GsonBuilder();    
			Gson gson = builder.enableComplexMapKeySerialization().create();
			JsonReader reader = new JsonReader(new FileReader(this.path));
			List<ScoreTableInput> scoreTablesFromJson = gson.fromJson(reader, SCORE_TABLE_INPUT_TYPE);
			for (ScoreTableInput scoreTableInput : scoreTablesFromJson) {
				String player = scoreTableInput.getPlayer();
				ScoreTableInput scoreTable = scoreTables.get(player);
				if (scoreTable == null) {
					scoreTable = new ScoreTableInput(player);
				}
				List<RollInput> rolls = scoreTableInput.getRolls();
				for (RollInput pinsDown : rolls) {
					scoreTable.addRoll(pinsDown);
				}
	        	scoreTables.put(player, scoreTable);
			}
			
			return new ArrayList<>(scoreTables.values());
		} catch(IOException e) {
			throw new InvalidInputFileException("Invalid input file: " + this.path + ".");
		}
	}

}
