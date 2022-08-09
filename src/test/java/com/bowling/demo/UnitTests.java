package com.bowling.demo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bowling.demo.helpers.BowlingHelper;
import com.bowling.demo.model.response.Player;

public class UnitTests {
	
	
	@Test
	public void testCalculationUserScoresNormalBehavior() {
		byte[] arr = {1, 2, 3, 4, 5, 3, 2, 1, 0, 4,1, 2, 3, 4, 5, 3, 2, 1, 0, 4,0,0,0,0};
		int score = BowlingHelper.getPlayerScore(arr);
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		assertEquals(score, sum);
	}
	
	
	
//	@Test
//	public void testNormalBehavior() {
//		Player some = new Player("some", 5, true);
//		Player one = new Player("one", 4, true);
//		Player el = new Player("else", 7, true);
//		
//		List<Player> players = new ArrayList<>();
//		players.add(some);
//		players.add(one);
//		players.add(el);
//		
//		BowlingHelper.getSortedPlayersByScores(players);
//		
//		assertEquals(players.get(0).getName(), el.getName());
//		
//	}
	
	
	
}
