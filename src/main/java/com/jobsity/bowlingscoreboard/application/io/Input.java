package com.jobsity.bowlingscoreboard.application.io;

import java.util.List;

import com.jobsity.bowlingscoreboard.infrastructure.dto.ScoreTableInput;

public interface Input {
	
	List<ScoreTableInput> read();

}
