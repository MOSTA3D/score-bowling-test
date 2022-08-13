package com.bowling.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bowling.demo.model.response.Player;
import com.bowling.demo.services.BowlingService;

public class ServiceTest {
	private Map<String, byte[]> playerMap;
	
	private BowlingService bowlingService = new BowlingService();
	
	@BeforeEach
	public void reInitialize() {
		// given for those who havn't one
		playerMap = new HashMap<>();
		byte[] scores = {1, 2, 3, 4, 5, 3, 2, 1, 0, 4, 1, 2, 3, 4, 5, 3, 2, 1, 0, 4, 0, 0};
		playerMap.put("sheka", scores);
		byte[] scores2 = scores.clone();
		scores2[0] = 6;
		playerMap.put("beka", scores2);
	}
	
	@Test
	public void testServiceNormalBehavior() {
		// when
		List<Player> playerList = bowlingService.getPlayerRanks(playerMap);
		
		// then
		assertNotNull(playerList);
	}
	
	@Test
	public void testResultServiceRightOrdering() {
		// when
		List<Player> playerList = bowlingService.getPlayerRanks(playerMap);
		
		// then
		assertEquals(playerList.get(0).getName(), "beka");
		assertEquals(playerList.get(1).getName(), "sheka");
	}
}
