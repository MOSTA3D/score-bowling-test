package com.bowling.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class ControllerTest {
	@Test
	public void testControllerWorking() {
		
	}
	
	@Test
	public void testControllerThrowingExeptionIfProvidingEmptyStringAsAKey() {
		Map<String, byte[]> players = new HashMap<>();
		byte[] scores = {1,2};
		players.put("", scores);
		
	}
}
