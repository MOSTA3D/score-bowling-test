package com.bowling.demo.dtos;

public class Player {
	private String name;
	private int score;
	private boolean isPerfect;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isPerfect() {
		return isPerfect;
	}

	public void setPerfect(boolean isPerfect) {
		this.isPerfect = isPerfect;
	}
}
