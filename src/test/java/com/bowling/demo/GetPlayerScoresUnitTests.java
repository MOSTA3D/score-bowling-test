package com.bowling.demo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.bowling.demo.helpers.BowlingHelper;
import com.bowling.demo.model.response.Player;

import Exception.BowlingException;

public class GetPlayerScoresUnitTests {
	
	// given
	private byte[] arr = {1, 2, 3, 4, 5, 3, 2, 1, 0, 4, 1, 2, 3, 4, 5, 3, 2, 1, 0, 4, 0, 0};
	private byte[] scores;
	private Executable executable;
	
	private Executable getScoresExecutable(byte[] tempArr) {
		return ()->{
			BowlingHelper.getPlayerScore(tempArr);
		};
	}
	
	private int getSum(byte[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
		}
		
		return sum;
	}
	
	@BeforeEach
	public void beforeEach() {
		scores = arr.clone(); 
	}
	
	@Test
	public void testCalculationUserScoresNormalBehavior() {
		// given
		int sum = this.getSum(scores);
		
		// when
		int score = BowlingHelper.getPlayerScore(scores);
		
		// then
		assertEquals(score, sum);
	}
	
	@Test
	public void testScoresWithOneStrike() {
		// given
		int testIndex = 0;
		scores[testIndex] = 10;
		scores[testIndex + 1] = 0;
		int sum = this.getSum(scores) + scores[testIndex + 2] + scores[testIndex + 3];
		
		// when
		int totalScore = BowlingHelper.getPlayerScore(scores);
		
		// then
		assertEquals(sum, totalScore);
	}
	
	@Test
	public void testScoresWithOneSpare() {
		// given
		int testIndex = 0;
		scores[testIndex] = 4;
		scores[testIndex + 1] = 6;
		int sum = this.getSum(scores) + scores[2];
		
		// when
		int totalScore = BowlingHelper.getPlayerScore(scores);
		
		// then
		assertEquals(sum, totalScore);
	}
	
	@Test
	public void testScoreWithOneSpareAndOneStrike() {
		// given
		int testIndexStrike = 0;
		int testIndexSpare = 6;
		
		scores[testIndexStrike] = 10;
		scores[testIndexStrike + 1] = 0;
		
		scores[testIndexSpare] = 4;
		scores[testIndexSpare + 1] = 6;
		
		int sum = this.getSum(scores) + scores[testIndexStrike + 2] + scores[testIndexStrike + 3];
		
		// when
		int totalScore = BowlingHelper.getPlayerScore(scores);
		
		// then
		assertEquals(sum, totalScore);
	}
	
	@Test
	public void testThrowingBowlingExceptionWhenProvidingDifferentLengthArr() {
		// given
		byte[] testArr = {1,2};
		
		// when, then
		assertThrows(BowlingException.class, getScoresExecutable(testArr));
	}
	
	@Test
	public void testThrowingExceptionWhen20thValueIsNotStrikeNorSpare() {
		// given
		byte[] scores = arr.clone();
		scores[20] = 20;
		
		// when, then
		assertThrows(BowlingException.class, getScoresExecutable(scores));
	}
	
	@Test
	public void testProvidingOutOfRangeScore() {
		// given
		byte[] scores = arr.clone();
		scores[5] = -1;
		
		// when, then
		assertThrows(BowlingException.class, getScoresExecutable(scores));
	}
}
