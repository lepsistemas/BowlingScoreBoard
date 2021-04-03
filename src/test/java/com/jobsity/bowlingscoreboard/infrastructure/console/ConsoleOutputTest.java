package com.jobsity.bowlingscoreboard.infrastructure.console;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jobsity.bowlingscoreboard.application.io.Output;

@ExtendWith(MockitoExtension.class)
public class ConsoleOutputTest {
	
	@Mock
	private PrintStream printStream;
	
	@Mock
	private ConsoleGameBoardsOutput board;
	
	@Test
	public void shouldWriteMessageToOutput() {
		when(this.board.toString()).thenReturn("ConsoleGameBoardsOutput");
		
		Output output = new ConsoleOutput(this.printStream);
		output.write(this.board);
		
		verify(this.printStream).print("ConsoleGameBoardsOutput");
		assertThat(output.formatter()).isExactlyInstanceOf(ConsoleFormatter.class);
	}

}
