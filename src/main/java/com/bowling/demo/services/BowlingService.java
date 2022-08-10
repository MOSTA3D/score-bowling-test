package com.bowling.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bowling.demo.helpers.BowlingHelper;
import com.bowling.demo.model.response.Player;

@Service
public class BowlingService {
	
	public List<Player> getPlayerRanks(Map<String, byte[]> playersScores) {
		List<Player> playersRanks = new ArrayList<>();
		
		playersScores.forEach((k, v)->{
			int score = BowlingHelper.getPlayerScore(v);
			playersRanks.add(new Player(k, score, (score==300 ? true : false)));
		});
		
		BowlingHelper.getSortedPlayersByScores(playersRanks);
		
		return playersRanks;
	}
}
