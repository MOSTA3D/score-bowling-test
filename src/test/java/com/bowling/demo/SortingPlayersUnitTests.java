package com.bowling.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bowling.demo.helpers.BowlingHelper;
import com.bowling.demo.model.response.Player;

public class SortingPlayersUnitTests {
	private Player some = new Player("some", 5, true);
	private Player one = new Player("one", 4, true);
	private Player el = new Player("else", 7, true);
	List<Player> players;
	
	
	@BeforeEach
	public void setupEach() {
		// given
		players = new ArrayList<>();
		players.add(some);
		players.add(one);
		players.add(el);
	}
	
	@Test
	public void testSortingPlayersNormalBehavior() {
		// when
		BowlingHelper.getSortedPlayersByScores(players);
		
		// then
		assertEquals(players.get(0).getName(), el.getName());
	}
	
	@Test
	public void testNotNullWhileEqualInScores() {
		some.setScore(5);
		one.setScore(5);
		el.setScore(5);
		
		BowlingHelper.getSortedPlayersByScores(players);
		assertNotNull(players);
	}
	
}
