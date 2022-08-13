package com.bowling.demo.helpers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bowling.demo.model.response.Player;

import Exception.BowlingException;

public class BowlingHelper {
	
	public static void getSortedPlayersByScores(List<Player> playersRanks){
		
		Collections.sort(playersRanks, new Comparator<Player>() {
			public int compare(Player p1, Player p2){
			     return p1.getScore() < p2.getScore() ? 1 : -1;
			  }
		});
	}
	
//	private 
	
	public static int getPlayerScore(byte[] scores) {
		
		if(scores.length != 22) {
			System.out.println("length must be 22");
			throw new BowlingException("Must be 22 in length");
		}
		
		if(scores[18] + scores[19] < 10 && scores[20] > 0) {
			System.out.println("the 18th is " + scores[18] + " and the 19th is " + scores[19]);
			throw new BowlingException("player didn't make a spare or strike");
		}
		
		int score = 0;
		for(int i = 0; i < 20; i+=2) {
			int value = scores[i];
			
			// validation
			if(value < 0 || scores[i+1] < 0 || value > 10 || scores[i+1] > 10 || (value == 10 && scores[i+1] != 0)) {
				System.out.println("out of range");
				throw new BowlingException("value is out of range");
			}
			
			if(value == 10) {
				if(i == 18) {
					// edgecase-1 : the 19th item
					
					score += (value + scores[i+2] + scores[i+3]);
					break;
				}
				score += (scores[i+2] + (scores[i+2] != 10 ? scores[i+3] : scores[i+4]));
			}else if(value + scores[i+1] == 10) {
				score += scores[i+2];
			}
			
			score += (value + scores[i+1]);
			
		}
		return score;
	}
	
}
