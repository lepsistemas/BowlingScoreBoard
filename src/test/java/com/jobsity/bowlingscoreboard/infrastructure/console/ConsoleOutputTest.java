package com.jobsity.bowlingscoreboard.infrastructure.console;

import static org.mockito.Mockito.verify;

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
	
	@Test
	public void shouldWriteMessageToOutput() {
		Output output = new ConsoleOutput(this.printStream);
		
		output.write("A message");
		
		verify(this.printStream).print("A message");
	}

}
